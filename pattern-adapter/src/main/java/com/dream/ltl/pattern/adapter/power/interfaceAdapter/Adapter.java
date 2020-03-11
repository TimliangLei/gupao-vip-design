package com.dream.ltl.pattern.adapter.power.interfaceAdapter;

public class Adapter implements DC5{


    private AC220 ac220 = null;

    public Adapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    public AC220 getAc220() {
        return ac220;
    }

    @Override
    public int output5V() {
        return ac220.outputAC220V()/44 ;
    }

    @Override
    public int output12V() {
        return 0;
    }

    @Override
    public int output24V() {
        return 0;
    }

    @Override
    public int output48V() {
        return 0;
    }
}
