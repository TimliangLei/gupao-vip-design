package com.dream.ltl.app.chain;

public class LoginHandler extends Handler {
    @Override
    public void doHandler(Member member) {
        System.out.println("登陆成功");
        if (super.next != null){
            super.next.doHandler(member);
        }
    }
}
