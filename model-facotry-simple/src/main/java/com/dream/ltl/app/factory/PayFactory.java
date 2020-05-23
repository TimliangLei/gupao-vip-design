package com.dream.ltl.app.factory;

import com.dream.ltl.app.api.IPay;

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
