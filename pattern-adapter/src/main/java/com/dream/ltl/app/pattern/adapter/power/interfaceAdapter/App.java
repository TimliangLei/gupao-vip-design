package com.dream.ltl.app.pattern.adapter.power.interfaceAdapter;

public class App {
    public static void main(String[] args) {
        DC5 adapter = new Adapter(new AC220());
        adapter.output5V();
    }
}
