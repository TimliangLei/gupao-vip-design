package com.dream.ltl.app.singleton.Lazy;

import java.lang.reflect.Constructor;

public class ReferTest {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = LazyStaticInnerClassSingleton.class;
        Constructor c = clazz.getDeclaredConstructor(null);
        c.setAccessible(true);
        LazyStaticInnerClassSingleton instance1  = (LazyStaticInnerClassSingleton) c.newInstance();

        System.out.println(instance1);
    }
}
