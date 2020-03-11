package com.dream.ltl.pattern.adapter.passport.adapterv2;

import com.dream.ltl.pattern.adapter.passport.adapterv2.thirdadapter.ILoginAdapter;
import com.dream.ltl.pattern.adapter.passport.pojo.ResultMsg;

public interface IPassportForThird {
//    ResultMsg loginForQQ(String openId);
//    ResultMsg loginForWeChat(String openId);
//    ResultMsg loginForPhone(String openId,String code);
//    ResultMsg loginForToken(String openId);
    ResultMsg processLogin(String id,Class<? extends ILoginAdapter> clazz);
}
