package com.dream.ltl.app.statiproxy;

public class App {
    public static void main(String[] args) {
        Father father = new Father(new Son());
        father.findLove();

    }
}
