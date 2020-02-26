package com.dream.ltl.singleton.register;

public enum  EnumSingleton  {
    INSTANCE;

    Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){

        return INSTANCE;
    }
}
