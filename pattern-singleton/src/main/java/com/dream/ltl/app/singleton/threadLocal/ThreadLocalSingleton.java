package com.dream.ltl.app.singleton.threadLocal;

public class ThreadLocalSingleton {

    private static final ThreadLocal<ThreadLocalSingleton> INSTANCE =
            new ThreadLocal<ThreadLocalSingleton>(){
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    private ThreadLocalSingleton() {
    }

    public static ThreadLocalSingleton getInstance(){
        return INSTANCE.get();
    }
}
