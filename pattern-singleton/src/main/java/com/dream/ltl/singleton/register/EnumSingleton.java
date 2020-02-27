package com.dream.ltl.singleton.register;

import com.dream.ltl.singleton.pojo.Pojo;

public enum  EnumSingleton  {
    INSTANCE;

    Pojo data = new Pojo();

    public Object getData() {
        return data;
    }


    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
