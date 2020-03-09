package com.dream.ltl.pattern.flyweight.ticket;

import java.util.Random;

public class TrainTicket implements ITicket {
    private String from;
    private String to;
    private String bunk;
    private int price;

    public TrainTicket(String from, String to, String bunk) {
        this.from = from;
        this.to = to;
        this.bunk = bunk;
    }

    @Override
    public void showInfo() {
        this.price = new Random().nextInt(500);
        System.out.println(from+" -> "+to+": "+bunk+" cost: "+price);
    }
}
