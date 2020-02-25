package com.dream.ltl.service.pay;

import com.dream.ltl.api.ICheck;
import com.dream.ltl.api.IPay;

public class VisaPay implements IPay {
    public void pay() {
        System.out.println("VisaPay Pay.");
    }
}
