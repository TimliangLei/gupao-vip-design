package com.dream.ltl.app.pay.payport;

public class JDPay extends Payment {
    @Override
    public String getName() {
        return "京东";
    }

    @Override
    public double queryBalance(String uid) {
        return 100;
    }
}
