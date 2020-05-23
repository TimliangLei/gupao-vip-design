package com.dream.ltl.mvcframework.context;

import com.dream.ltl.mvcframework.beans.GPBeanWrapper;
import com.dream.ltl.mvcframework.beans.config.GPBeanDefinition;
import com.dream.ltl.mvcframework.beans.support.GPBeanDefinitionReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * 职责：完成Bean创建和DI
 */
public class GPApplicationContext {


    private GPBeanDefinitionReader reader;

    private Map<String, GPBeanDefinition> beanDefinitionMap = new HashMap();
    private Map<String,GPBeanWrapper> factoryBeanInstanceCache = new HashMap<String, GPBeanWrapper>();
    private Map<String,Object> factoryBeanObjectCache = new HashMap<String, Object>();
    public GPApplicationContext(String... configLocation) {

//        1、加载配置文件
        reader = new GPBeanDefinitionReader(configLocation);
        try {


//        2、解析配置文件，封装成BeanDefinition
            List<GPBeanDefinition> beanDefinitionList = reader.loadBeanDefinitions();

//        3、把BeanDefinition缓存起来
            doRegistBeanDefinition(beanDefinitionList);

            doAutoWrited();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void doAutoWrited() {
        //调用getBean才触发
        for(Map.Entry<String,GPBeanDefinition> entry: this.beanDefinitionMap.entrySet()){
            String beanName = entry.getKey();
            getBean(beanName);
        }
    }

    private void doRegistBeanDefinition(List<GPBeanDefinition> beanDefinitionList) throws Exception {
        for (GPBeanDefinition beanDefinition:beanDefinitionList){
            if (this.beanDefinitionMap.containsKey(beanDefinition.getFactoryBeanName())){
                throw new Exception("The "+beanDefinition.getFactoryBeanName()+" is exits");
            }
            beanDefinitionMap.put(beanDefinition.getFactoryBeanName(),beanDefinition);
            beanDefinitionMap.put(beanDefinition.getBeanClassName(),beanDefinition);
        }
    }

    public Object getBean(String beanName){
        //1、先拿到配置信息beanDefinition
        GPBeanDefinition beanDefinition = this.beanDefinitionMap.get(beanName);
        //todo 2、反射实例化
        Object instance = instantiateBean(beanName,beanDefinition);
        //3、封装成BeanWrap
        GPBeanWrapper beanWrapper = new GPBeanWrapper(instance);
        //4、保存到IoC容器
        factoryBeanInstanceCache.put(beanName,beanWrapper);
        //todo 5、执行依赖注入
        populateBean(beanName,beanDefinition,beanWrapper);
        
        return beanWrapper.getWrapperClass();
    }

    private void populateBean(String beanName, GPBeanDefinition beanDefinition, GPBeanWrapper beanWrapper) {

    }

    private Object instantiateBean(String beanName, GPBeanDefinition beanDefinition) {

        return null;
    }

    public Object getBean(Class beanClass){
        return getBean(beanClass.getName());
    }
}
