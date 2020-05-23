package com.dream.ltl.app.chain;

public class MemberService {
    public void login(){

        Handler.Builder builder = new Handler.Builder();
        builder.addHandler(new ValidateHandler())
                .addHandler(new LoginHandler());
        Handler handler = builder.build();
        handler.doHandler(null);
    }
}
