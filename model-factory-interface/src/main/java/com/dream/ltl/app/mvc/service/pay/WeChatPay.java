package com.dream.ltl.app.mvc.service.pay;

import com.dream.ltl.app.api.IPay;

public class WeChatPay implements IPay {
    public void pay() {
        System.out.println("WeChatPay Pay.");
    }

}
