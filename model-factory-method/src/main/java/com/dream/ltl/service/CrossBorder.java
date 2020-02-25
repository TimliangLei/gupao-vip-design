package com.dream.ltl.service;

import com.dream.ltl.api.IPay;

public class CrossBorder implements IPay {
    public void pay() {
        System.out.println("Cross Border Pay.");
    }
}
