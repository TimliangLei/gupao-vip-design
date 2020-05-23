package com.dream.ltl.app.dbroute.db;

import sun.rmi.runtime.Log;

public class DynamicDataSource {
    public final static String DEFAULT_SOURCE = null;
    private final static  ThreadLocal<String> local = new ThreadLocal<>();

    private DynamicDataSource() {
    }

    private static String get(){
        return local.get();
    }

    public static void restore(){
        local.set(DEFAULT_SOURCE);
    }

    public static void set(String source){
        local.set(source);
    }
    public static void set(int year){
        local.set("DB_"+year);
    }
}
