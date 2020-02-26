package com.dream.ltl.singleton.register;

import com.dream.ltl.singleton.pojo.Pojo;

public class EnumSingletonTest {
    public static void main(String[] args) {
        EnumSingleton enumSingleton = EnumSingleton.getInstance();
        enumSingleton.setData(new Pojo());
    }
}
