package com.dream.ltl.app.pay;

import com.dream.ltl.app.pay.payport.*;


import java.util.HashMap;
import java.util.Map;

public class PayStrategy {

    private PayStrategy() {
    }

    public static final  String ALI_PAY = "ALIPay";
    public static final  String WECHAT_PAY = "WeChatPay";
    public static final  String JD_PAY = "JDPay";
    public static final  String UNION_PAY = "UnionPay";
    public static final String DEFAULT_PAY = "DefaultPay";

    private static Map<String, Payment> strategy = new HashMap<>();

    static {
        strategy.put(ALI_PAY,new AliPay());
        strategy.put(JD_PAY,new JDPay());
        strategy.put(WECHAT_PAY,new WeChatPay());
        strategy.put(UNION_PAY,new UnionPay());
        strategy.put(DEFAULT_PAY,new AliPay());
    }

    public static Payment getPayMent(String param){
        return strategy.get(param);
    }


}
