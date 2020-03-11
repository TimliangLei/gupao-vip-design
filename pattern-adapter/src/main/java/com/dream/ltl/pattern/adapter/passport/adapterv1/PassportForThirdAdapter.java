package com.dream.ltl.pattern.adapter.passport.adapterv1;


import com.dream.ltl.pattern.adapter.passport.pojo.PassportService;
import com.dream.ltl.pattern.adapter.passport.pojo.ResultMsg;

public class PassportForThirdAdapter extends PassportService implements IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String openID) {
        return loginForRegist(openID,null);
    }

    @Override
    public ResultMsg loginForWeChat(String openID) {
        return loginForRegist(openID,null);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return loginForRegist(token,null);
    }

    @Override
    public ResultMsg loginForPhone(String phone, String code) {
        return loginForRegist(phone,null);
    }

    private ResultMsg loginForRegist(String username, String password){
        if (null == password){
            password="THIRD_EMPTY";
        }

        super.regist(username,password);
        return super.login(username, password);
    }
}
