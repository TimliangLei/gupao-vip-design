package com.dream.ltl.service;

import com.dream.ltl.api.IPay;

public class WeChat implements IPay {
    public void pay() {
        System.out.println("WeChat Pay.");
    }
}
