package com.dream.ltl;

import com.dream.ltl.factory.PayFactory;

public class App {
    public static void main(String[] args) {
        PayFactory.create("com.dream.ltl.pojo.Alibaba");
        PayFactory.create("com.dream.ltl.pojo.CrossBorder");
    }
}
