package com.dream.ltl.factory;

import com.dream.ltl.api.IPay;

public class PayFactory {

    private PayFactory() {
    }


    public static void create(String method){
        try {
            IPay pay = (IPay) Class.forName(method).newInstance();
            pay.pay();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
