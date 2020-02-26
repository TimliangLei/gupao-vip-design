package com.dream.ltl.singleton.Lazy;


/**
 * ClassPath: LazyStaticInnerClassSingleton.class 先扫描这个类
 *              LazyStaticInnerClassSingleton$LazyHolder.class 用到再扫描
 *      优点：写法优雅，利用java本身特点，性能高，避免内存浪费
 *      缺点：能够被反射破坏
 */
public class LazyStaticInnerClassSingleton {
    private volatile static LazyStaticInnerClassSingleton instance = null;

    private LazyStaticInnerClassSingleton() {
        if (LazyHolder.INSTANCE != null){
            throw  new RuntimeException("不允许非法访问");
        }
    }

    public static LazyStaticInnerClassSingleton getInstance(){

        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder{
        private static final LazyStaticInnerClassSingleton INSTANCE= new LazyStaticInnerClassSingleton();
    }
}
