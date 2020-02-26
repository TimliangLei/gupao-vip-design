package com.dream.ltl.singleton.springIOC;

public class App {
    public static void main(String[] args) throws Exception {
        Object o = ContainerSingleton.getInstance("com.dream.ltl.singleton.pojo.Pojo");
        System.out.println(o);
    }
}
