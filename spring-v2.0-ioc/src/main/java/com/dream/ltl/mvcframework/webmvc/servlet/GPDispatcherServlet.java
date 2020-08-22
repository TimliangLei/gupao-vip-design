package com.dream.ltl.mvcframework.webmvc.servlet;

import com.dream.ltl.mvcframework.annotations.*;
import com.dream.ltl.mvcframework.beans.GPBeanWrapper;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 委派模式
 * 职责：分发任务
 */
public class GPDispatcherServlet extends HttpServlet {

    private List<GPHandlerMapping> handlerMapping = new ArrayList<GPHandlerMapping>();
    private Map<GPHandlerMapping,GPHandlerAdapter> handlerAdapters = new HashMap<GPHandlerMapping, GPHandlerAdapter>();
    @Override
    public void init(ServletConfig config) throws ServletException {
//        初始化Spring核心IoC容器
        GPApplicationContext applicationContext = new GPApplicationContext(config.getInitParameter("contextConfigLocation"));
        //初始化9大组件
        initStrategies(applicationContext);
        System.out.println("GP Spring framework is finish.");
    }

    private void initStrategies(GPApplicationContext applicationContext) {
        initHandleMapping(applicationContext);
        initHandlerAdapters();
        initViewResolvers(applicationContext);
    }



    private void initHandleMapping(GPApplicationContext applicationContext) {
        if (applicationContext.getFactoryBeanInstanceCacheSize()==0) return;
        for (String beanName : applicationContext.getFactoryBeanInstanceCacheNames()){

            GPBeanWrapper beanWrapper = applicationContext.getBean(beanName);
            Class<?> clazz = beanWrapper.getWrapperClass();
            if (!clazz.isAnnotationPresent(GPController.class)) continue;

            String baseUrl = "";
            if (clazz.isAnnotationPresent(GPRequestMapping.class)){
                GPRequestMapping requestMapping = clazz.getAnnotation(GPRequestMapping.class);
                baseUrl = requestMapping.value();
            }

            for (Method method: clazz.getMethods()){
                if (!method.isAnnotationPresent(GPRequestMapping.class))continue;
                GPRequestMapping requestMapping = method.getAnnotation(GPRequestMapping.class);

                // /demo/query
                String regex = ("/" + baseUrl + "/" + requestMapping.value().replaceAll("\\*",".*"))
                        .replaceAll("/+","/");
                Pattern pattern = Pattern.compile(regex);
                handlerMapping.add(new GPHandlerMapping(pattern,method,beanWrapper.getWrapperInstance()));
                System.out.println("Mapping: "+ regex + ","+method);
            }
        }

    }


    private void initHandlerAdapters() {
        for(GPHandlerMapping handlerMapping:handlerMapping){
            this.handlerAdapters.put(handlerMapping,new GPHandlerAdapter());
        }
    }
    private void initViewResolvers(GPApplicationContext applicationContext) {
        applicationContext.getConfig().getProperty("");
    }

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
        // 1. 通过URL获得一个HandlerMapping
        GPHandlerMapping handler = getHandler(req);
        if(handler == null){
            processDispatchResult(req,resp,new GPModelAndView("404"));
        }

        // 2. 根据一个HandlerMapping获得一个HandlerAdapter, 解析形参和返回值
        GPHandlerAdapter adapter = getHandlerAdapter(handler);

        // 3.解析某个方法形参和返回值，同意封装为ModelAndView对象
        GPModelAndView mv = adapter.handler(req,resp,handler);

        //todo 4.把ModelAndView变成ViewResolver,
        processDispatchResult(req,resp,new GPModelAndView("404"));
    }

    private GPHandlerAdapter getHandlerAdapter(GPHandlerMapping handler) {
        if (this.handlerAdapters.isEmpty())return null;

        return this.handlerAdapters.get(handler);
    }

    private void processDispatchResult(HttpServletRequest req,
                                       HttpServletResponse resp,
                                       GPModelAndView mv) {

        if (mv == null)return;

    }

    private GPHandlerMapping getHandler(HttpServletRequest req) {
        if (this.handlerMapping.isEmpty())return null;
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replaceAll(contextPath,"")
                .replaceAll("/+","/");

        for (GPHandlerMapping mapping:handlerMapping){
            Matcher matcher = mapping.getPattern().matcher(url);
            if (!matcher.matches())continue;
            return mapping;
        }
        return null;
    }




}
