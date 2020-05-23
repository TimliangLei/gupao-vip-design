package com.dream.ltl.app.singleton.register;

import com.dream.ltl.app.singleton.pojo.Pojo;

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
