package com.dream.ltl.singleton.springIOC;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 现场安全问题
 */

public class ContainerSingleton {
    private ContainerSingleton(){}
    private static volatile Map<String,Object> ioc = new ConcurrentHashMap<String,Object>();

    public static Object getInstance(String className) throws Exception {
            if (!ioc.containsKey(className)){
                synchronized (ContainerSingleton.class) {
                    if (!ioc.containsKey(className)) {
                        Object instance = Class.forName(className).newInstance();
                        ioc.put(className, instance);
                    }
                }
            }
            return ioc.get(className);
    }
}
