package com.dream.ltl.app.pay.payport;

public class UnionPay extends Payment {
    @Override
    public String getName() {
        return "银联";
    }

    @Override
    public double queryBalance(String uid) {
        return 120;
    }
}
