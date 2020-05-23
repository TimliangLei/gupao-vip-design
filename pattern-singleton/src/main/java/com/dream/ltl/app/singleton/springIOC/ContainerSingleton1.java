package com.dream.ltl.app.singleton.springIOC;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton1 {
    private ContainerSingleton1(){}
    private static Map<String,Object> ioc = new ConcurrentHashMap<String,Object>();

    public synchronized static Object getInstance(String className) throws Exception {
        if (!ioc.containsKey(className)) {

            if (!ioc.containsKey(className)) {
                Object instance = Class.forName(className).newInstance();
                ioc.put(className, instance);
            }
        }
        return ioc.get(className);
    }
}
