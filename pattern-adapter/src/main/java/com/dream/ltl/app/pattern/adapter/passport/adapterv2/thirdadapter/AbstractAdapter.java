package com.dream.ltl.app.pattern.adapter.passport.adapterv2.thirdadapter;

import com.dream.ltl.app.pattern.adapter.passport.pojo.PassportService;
import com.dream.ltl.app.pattern.adapter.passport.pojo.ResultMsg;

public abstract class AbstractAdapter extends PassportService implements ILoginAdapter {
    protected ResultMsg loginForRegist(String username, String password){
        if (null == password){
            password="THIRD_EMPTY";
        }
        super.regist(username,password);
        return super.login(username, password);
    }
}
