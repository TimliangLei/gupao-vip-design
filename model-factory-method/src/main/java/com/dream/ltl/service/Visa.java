package com.dream.ltl.service;

import com.dream.ltl.api.IPay;

public class Visa implements IPay {
    public void pay() {
        System.out.println("Visa Pay.");
    }
}
