package com.dream.ltl.app.pattern.adapter.power.classadapter;

/**
 * 违背最少指导原则
 */
public class App {
    public static void main(String[] args) {
        PowerAdapter adapter = new PowerAdapter();
        adapter.output5V();
        adapter.outputAC220V();
    }
}
