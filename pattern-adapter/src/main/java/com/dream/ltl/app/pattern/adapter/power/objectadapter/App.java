package com.dream.ltl.app.pattern.adapter.power.objectadapter;


public class App {
    public static void main(String[] args) {
        DC5 adapter = new PowerAdapter(new AC220());
        adapter.output5V();
    }
}
