package com.dream.ltl.pattern.adapter.passport.adapterv2;


import com.dream.ltl.pattern.adapter.passport.adapterv2.thirdadapter.*;
import com.dream.ltl.pattern.adapter.passport.pojo.ResultMsg;

public class PassportForThirdAdapter implements IPassportForThird {
    /*
    @Override
    public ResultMsg loginForQQ(String openID) {
        return processLogin(openID, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWeChat(String openID) {
        return processLogin(openID, LoginForWeChatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token, LoginForTokenAdapter.class);
    }

    @Override
    public ResultMsg loginForPhone(String phone, String code) {
        return processLogin(phone, LoginForPhoneAdapter.class);
    }
    */


    public ResultMsg processLogin(String id,Class<? extends ILoginAdapter> clazz){
        try {
            ILoginAdapter instance = clazz.newInstance();
            if (instance.support(instance)){
                return instance.login(id,null);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;

    }



}
