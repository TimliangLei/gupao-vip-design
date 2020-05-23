package com.dream.ltl.app.mvc.service.pay;

import com.dream.ltl.app.api.IPay;

public class VisaPay implements IPay {
    public void pay() {
        System.out.println("VisaPay Pay.");
    }
}
