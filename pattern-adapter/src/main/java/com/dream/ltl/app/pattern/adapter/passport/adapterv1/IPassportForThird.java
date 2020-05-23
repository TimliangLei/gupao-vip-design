package com.dream.ltl.app.pattern.adapter.passport.adapterv1;

import com.dream.ltl.app.pattern.adapter.passport.pojo.ResultMsg;

public interface IPassportForThird {
    ResultMsg loginForQQ(String openID);
    ResultMsg loginForWeChat(String openID);
    ResultMsg loginForToken(String token);
    ResultMsg loginForPhone(String phone,String code);
}
