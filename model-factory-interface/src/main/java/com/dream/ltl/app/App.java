package com.dream.ltl.app;

import com.dream.ltl.app.factroy.IPaymentFactory;
import com.dream.ltl.app.factroy.PaymentFactory;
import com.dream.ltl.app.pojo.SysConfig;

public class App {
    public static void main(String[] args) {
        SysConfig sysConfig = new SysConfig(
                "com.dream.ltl.service.check.AlibabaCheck",
                "com.dream.ltl.service.pay.AlibabaPay");
        IPaymentFactory paymentFactory = new PaymentFactory();
        paymentFactory.deal(sysConfig);
    }
}
