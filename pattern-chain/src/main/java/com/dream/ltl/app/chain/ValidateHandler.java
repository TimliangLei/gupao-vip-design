package com.dream.ltl.app.chain;

public class ValidateHandler extends Handler {
    @Override
    public void doHandler(Member member) {
        System.out.println("校验成功");
        if (super.next != null){
            super.next.doHandler(member);
        }
    }
}
