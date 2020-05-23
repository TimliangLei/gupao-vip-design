package com.dream.ltl.app.delegeate.company;

public class App {
    public static void main(String[] args) {
        new Boss().command("海报图",new Leader());
    }
}
