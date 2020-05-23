package com.dream.ltl.app.singleton.register;

public class EnumSingletonTest {
    public static void main(String[] args) {
        System.out.println(EnumSingleton.getInstance().getData());
        System.out.println(EnumSingleton.getInstance().getData());
    }
}
