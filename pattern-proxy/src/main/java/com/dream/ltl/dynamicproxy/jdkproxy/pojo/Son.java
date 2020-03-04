package com.dream.ltl.dynamicproxy.jdkproxy.pojo;


public class Son implements IPerson {

    @Override
    public void findLove() {
        System.out.println("son 肤白貌美，大长腿");

    }

    public void buyInsurence() {
        System.out.println("buy 100w");
    }

}
