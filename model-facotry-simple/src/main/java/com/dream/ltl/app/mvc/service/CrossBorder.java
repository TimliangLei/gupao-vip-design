package com.dream.ltl.app.mvc.service;

import com.dream.ltl.app.api.IPay;

public class CrossBorder implements IPay {
    public void pay() {
        System.out.println("Cross Border Pay.");
    }
}