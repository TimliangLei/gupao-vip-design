package com.dream.ltl.app.pay.payport;

public class WeChatPay extends Payment {
    @Override
    public String getName() {
        return "微信";
    }

    @Override
    public double queryBalance(String uid) {
        return 500;
    }
}
