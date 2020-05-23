package com.dream.ltl.app.mvc.service;

import com.dream.ltl.app.api.IPay;

public class Visa implements IPay {
    public void pay() {
        System.out.println("Visa Pay.");
    }
}
