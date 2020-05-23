package com.dream.ltl.app.pay;

public class App {
    public static void main(String[] args) {
        Order order = new Order("1","20200314",300);
        System.out.println(order.pay(PayStrategy.JD_PAY));
    }
}
