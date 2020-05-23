package com.dream.ltl.mvcframework.webmvc.servlet;

import com.dream.ltl.mvcframework.annotations.*;
import com.dream.ltl.mvcframework.context.GPApplicationContext;
import javafx.application.Application;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * 委派模式
 * 职责：分发任务
 */
public class GPDispatcherServlet extends HttpServlet {
    private GPApplicationContext applicationContext = null;



//    简化程序不考虑ConcurrentHashMap,关注设计思想和原理
    private Map<String,Object> ioc = new HashMap<String, Object>();
    private Map<String,Method> handlerMapping = new HashMap<String, Method>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        todo 6、 调用
        try {
            doDispatch(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("500 Exception,Detail : "+Arrays.toString(e.getStackTrace()));
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replaceAll(contextPath,"").replaceAll("/+","/");

        if (!this.handlerMapping.containsKey(url)){
            resp.getWriter().write("404 Not Found !!!");
            return;
        }
        Method method = this.handlerMapping.get(url);

        Map<String,String[]> params = req.getParameterMap();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Object[] parameterValues = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++){
            Class parameterType = parameterTypes[i];
            if (parameterType == HttpServletRequest.class){
                parameterValues[i] = req;
            }else if (parameterType == HttpServletResponse.class){
                parameterValues[i] = resp;
            }else if (parameterType == String.class){
                Annotation[][] pa = method.getParameterAnnotations();
                for(int j = 0; j < pa.length;j++){
                    for (Annotation a:pa[j]){
                        if (a instanceof GPRequestParam){
                            String paramName = ((GPRequestParam) a).value();
                            if (!"".equals(paramName.trim())){
                                String value = Arrays.toString(params.get(paramName))
                                        .replaceAll("\\[|\\]","")
                                        .replaceAll("\\s+",",");
                                parameterValues[i] = value;
                            }
                        }
                    }
                }

            }
        }

        String beanName = toLowerFirstCase(method.getDeclaringClass().getSimpleName());
        method.invoke(ioc.get(beanName),parameterValues);

    }
    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
//        初始化Spring核心IoC容器
        applicationContext = new GPApplicationContext(config.getInitParameter("contextConfigLocation"));
//        //todo 1\加载配置文件
//        doLoadConfig(config.getInitParameter("contextConfigLocation"));
//        //todo 2、扫描相关的类
//        doScanner(contextConfig.getProperty("scanPackage"));
//        //todo 3\初始化扫描到的类，并且放入到IOC容器中
//        doInstance();
//        //todo 4、完成依赖注入
//        doAutowired();
//        //todo 5、初始化HandlerMapping
//        initHandleMapping();

        System.out.println("GP Spring framework is finish.");
    }

    private void initHandleMapping() {
        if (ioc.isEmpty()) return;
        for (Map.Entry<String,Object> entry : ioc.entrySet()){
            Class<?> clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(GPController.class)) continue;

            String baseUrl = "";
            if (clazz.isAnnotationPresent(GPRequestMapping.class)){
                GPRequestMapping requestMapping = clazz.getAnnotation(GPRequestMapping.class);
                baseUrl = requestMapping.value();
            }

            for (Method method: clazz.getMethods()){
                if (!method.isAnnotationPresent(GPRequestMapping.class))continue;
                GPRequestMapping requestMapping = method.getAnnotation(GPRequestMapping.class);
                String url = ("/" + baseUrl + "/" + requestMapping.value()).replaceAll("/+","/");
                handlerMapping.put(url,method);
                System.out.println("Mapping: "+ url + ","+method);
            }
        }

    }
    private List<String> classNames = new ArrayList<String>();
    private void doInstance() {
        if (classNames.isEmpty()) return;

        try {
            for (String className : classNames) {
                if(!className.contains(".")){continue;}
                Class<?> clazz = Class.forName(className);

                if (clazz.isAnnotationPresent(GPController.class)) {
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    Object instance = clazz.newInstance();
                    ioc.put(beanName, instance);
                }else if (clazz.isAnnotationPresent(GPService.class)){
                    //1、在多个包下出现相同类名，
                    String beanName = clazz.getAnnotation(GPService.class).value();
                    if ("".equals(beanName)){
                        beanName = toLowerFirstCase(clazz.getSimpleName());
                    }

                    //2、默认类名小写
                    Object instance = clazz.newInstance();
                    ioc.put(beanName, instance);

                    //3、如果是接口
                    //判断有多少个实现类，
                    for(Class<?> i:clazz.getInterfaces()){
                        if (ioc.containsKey(i.getName())) {
                            throw new Exception("The" + i.getName() + " is exists!!");
                        }
                        ioc.put(i.getName(),instance);
                    }


                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void doAutowired() {
        if (ioc.isEmpty()){return;}
        for (Map.Entry<String,Object> entry : ioc.entrySet()){
//            获取所有的，包括private/protected/default/public修饰字段
            for (Field field : entry.getValue().getClass().getDeclaredFields()){
                if(!field.isAnnotationPresent(GPAutowired.class)){continue;}
                GPAutowired autowired = field.getAnnotation(GPAutowired.class);
                String beanName = autowired.value().trim();
                if ("".equals(beanName)){
                    beanName = field.getType().getName();
                }
                field.setAccessible(true);
                try {
                    field.set(entry.getValue(),ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }




}
