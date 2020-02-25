package com.dream.ltl.service;

import com.dream.ltl.api.IPay;

public class Alibaba implements IPay {
    public void pay() {
        System.out.println("Alibaba Pay.");
    }
}
