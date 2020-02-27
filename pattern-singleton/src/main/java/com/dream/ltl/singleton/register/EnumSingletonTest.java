package com.dream.ltl.singleton.register;

import com.dream.ltl.singleton.pojo.Pojo;

public class EnumSingletonTest {
    public static void main(String[] args) {
        System.out.println(EnumSingleton.getInstance().getData());
        System.out.println(EnumSingleton.getInstance().getData());
    }
}
