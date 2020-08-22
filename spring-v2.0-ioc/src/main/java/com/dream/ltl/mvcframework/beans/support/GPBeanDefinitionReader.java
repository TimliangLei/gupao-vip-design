package com.dream.ltl.mvcframework.beans.support;

import com.dream.ltl.mvcframework.beans.config.GPBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GPBeanDefinitionReader {

    //保存application.properties配置文件
    private Properties contextConfig = new Properties();
    //    保存所有扫描到的类名 享元模式，缓存
    private List<String> registryBeanClasses = new ArrayList<String>();

    public GPBeanDefinitionReader(String... configLocation) {
        doLoadConfig(configLocation[0]);

        //扫描配置文件中相关类
        doScanner(contextConfig.getProperty("scanPackage"));
    }

    public List<GPBeanDefinition> loadBeanDefinitions() {
        List<GPBeanDefinition> result = new ArrayList<GPBeanDefinition>();

            try {
                for(String className:registryBeanClasses) {
                    Class<?> beanClass = Class.forName(className);
                    //保存类对应的ClassName(全类名),beanName

                    //1、默认类名首字母小写
                    result.add(doCreateBeanDefinition(toLowerFirstCase(beanClass.getSimpleName()),beanClass.getName()));
                    //2、自定义
                    //3、接口注入
                    for(Class<?> i:beanClass.getInterfaces()){
                        result.add(doCreateBeanDefinition(toLowerFirstCase(i.getSimpleName()),beanClass.getName()));
                    }
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();

        }
        return result;
    }
    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private GPBeanDefinition doCreateBeanDefinition(String beanName,String beanClassName){
        GPBeanDefinition beanDefinition = new GPBeanDefinition();
        beanDefinition.setBeanClassName(beanClassName);
        beanDefinition.setFactoryBeanName(beanName);
        return  beanDefinition;
    }

    private void doScanner(String scanPackage) {
        URL url = this.getClass().getClassLoader().getResource("/"+scanPackage.replaceAll("\\.","/"));
        File classPath = new File(url.getFile());
        for(File file:classPath.listFiles()){
            if (file.isDirectory()){
                doScanner(scanPackage+"."+file.getName());
            }else {
                if (!file.getName().endsWith(".class")){continue;}
                String className = (scanPackage +"."+file.getName().replace(".class",""));
                registryBeanClasses.add(className);
            }
        }
    }
    // 加载配置文件
    private void doLoadConfig(String contextConfigLocation) {
        //直接从类路径下找到spring配置文件所在路径
        //并且放到Properties中
        InputStream fis = this.getClass().getClassLoader().getResourceAsStream(
                contextConfigLocation
                        .replaceAll("classpath:",""));
        try {
            contextConfig.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != fis){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Properties getContextConfig() {
        return contextConfig;
    }
}
