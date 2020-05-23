package com.dream.ltl.app.statiproxy;

public class Father implements IPerson {
    private Son son;

    public Father(Son son) {
        this.son = son;
    }

    public void findLove() {
        System.out.println("父亲开始物色");
        son.findLove();

    }
}
