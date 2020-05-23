package com.dream.ltl.app.pay;

import com.dream.ltl.app.pay.payport.Payment;

public class Order {
    private String uid;
    private String orderID;
    private double amount;

    public Order(String uid, String orderID, double amount) {
        this.uid = uid;
        this.orderID = orderID;
        this.amount = amount;
    }

    public MsgResult pay(){
        return pay(PayStrategy.DEFAULT_PAY);
    }

    public MsgResult pay(String param){

        Payment payment = PayStrategy.getPayMent(param);
        System.out.println(payment.getName());
        payment.pay(uid,amount);
        return payment.pay(uid,amount);
    }
}
