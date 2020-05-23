package com.dream.ltl.app.pay.payport;

public class AliPay extends Payment {

    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    public double queryBalance(String uid) {
        return 500;
    }
}
