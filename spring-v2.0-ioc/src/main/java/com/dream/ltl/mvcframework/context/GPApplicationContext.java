package com.dream.ltl.mvcframework.context;

import com.dream.ltl.mvcframework.annotations.GPAutowired;
import com.dream.ltl.mvcframework.annotations.GPController;
import com.dream.ltl.mvcframework.annotations.GPService;
import com.dream.ltl.mvcframework.beans.GPBeanWrapper;
import com.dream.ltl.mvcframework.beans.config.GPBeanDefinition;
import com.dream.ltl.mvcframework.beans.support.GPBeanDefinitionReader;

import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.Logger;


/**
 *
 * 职责：完成Bean创建和DI
 */
public class GPApplicationContext {
    private GPBeanDefinitionReader reader;

    private Map<String, GPBeanDefinition> beanDefinitionMap = new HashMap();
    private Map<String,GPBeanWrapper> factoryBeanInstanceCache = new HashMap<String, GPBeanWrapper>();
//    private Map<String,Object> factoryBeanObjectCache = new HashMap<String, Object>();

    public GPApplicationContext(String... configLocation) {

//        1、加载配置文件
        reader = new GPBeanDefinitionReader(configLocation);
        try {


//        2、解析配置文件，封装成BeanDefinition
            List<GPBeanDefinition> beanDefinitionList = reader.loadBeanDefinitions();

//        3、把BeanDefinition缓存起来
            doRegistBeanDefinition(beanDefinitionList);

            doAutoWrited();
            System.out.println("beanDefinitionMap size:"+beanDefinitionMap.size()+
                    " factoryBeanInstanceCache size:"+factoryBeanInstanceCache.size());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<String> getFactoryBeanInstanceCacheNames() {
        return new ArrayList<String>(factoryBeanInstanceCache.keySet());
    }

    public int getFactoryBeanInstanceCacheSize() {
        return factoryBeanInstanceCache.size();
    }

    public GPBeanWrapper getBean(String beanName){
        return factoryBeanInstanceCache.get(beanName);
    }
    private void doRegistBeanDefinition(List<GPBeanDefinition> beanDefinitionList) throws Exception {
        for (GPBeanDefinition beanDefinition:beanDefinitionList){
            if (this.beanDefinitionMap.containsKey(beanDefinition.getFactoryBeanName())){

                continue;
//                throw new Exception("The "+beanDefinition.getFactoryBeanName()+" is exits");
            }
            beanDefinitionMap.put(beanDefinition.getFactoryBeanName(),beanDefinition);
            beanDefinitionMap.put(beanDefinition.getBeanClassName(),beanDefinition);
        }
    }

    private void doAutoWrited() {
        //调用getBean才触发
        for(Map.Entry<String,GPBeanDefinition> entry: this.beanDefinitionMap.entrySet()){
            String beanName = entry.getKey();
            doDI(beanName);
        }


    }
    private Object doDI(String beanName){
        //1、先拿到配置信息beanDefinition
        GPBeanDefinition beanDefinition = this.beanDefinitionMap.get(beanName);
        //2、反射实例化
        Object instance = instantiateBean(beanName,beanDefinition);
        //3、封装成BeanWrap
        GPBeanWrapper beanWrapper = new GPBeanWrapper(instance);
        //4、保存到IoC容器
        factoryBeanInstanceCache.put(beanName,beanWrapper);
        //5、执行依赖注入DI
        populateBean(beanName,beanDefinition,beanWrapper);

        return beanWrapper.getWrapperClass();
    }

    private void populateBean(String beanName, GPBeanDefinition beanDefinition, GPBeanWrapper beanWrapper) {
        //可能会涉及到循环依赖？
        Object instance = beanWrapper.getWrapperInstance();

        Class<?> clazz = beanWrapper.getWrapperClass();

        if (!(clazz.isAnnotationPresent(GPController.class) || !clazz.isAnnotationPresent(GPService.class))){
            return;
        }

        for (Field field : clazz.getDeclaredFields()){
            if(!field.isAnnotationPresent(GPAutowired.class)){continue;}

            GPAutowired autowired = field.getAnnotation(GPAutowired.class);
            String autowiredBeanName = autowired.value().trim();
            if ("".equals(autowiredBeanName)){
                autowiredBeanName = field.getType().getName();
            }
            field.setAccessible(true);
            try {
                if (this.factoryBeanInstanceCache.get(autowiredBeanName)==null) continue;
                field.set(instance, factoryBeanInstanceCache.get(autowiredBeanName));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                continue;
            }
        }

    }



    //创建真正的实例对象
    private Object instantiateBean(String beanName, GPBeanDefinition beanDefinition) {
        String className = beanDefinition.getBeanClassName();
        Object instance = null;
        try {
            Class<?> clazz = Class.forName(className);
            instance = clazz.newInstance();

//            this.factoryBeanObjectCache.put(beanName,instance);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return instance;
    }


    public Properties getConfig() {
        return reader.getContextConfig();
    }
}
