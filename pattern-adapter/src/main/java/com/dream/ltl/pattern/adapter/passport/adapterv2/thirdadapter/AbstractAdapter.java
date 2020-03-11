package com.dream.ltl.pattern.adapter.passport.adapterv2.thirdadapter;

import com.dream.ltl.pattern.adapter.passport.adapterv2.thirdadapter.ILoginAdapter;
import com.dream.ltl.pattern.adapter.passport.pojo.PassportService;
import com.dream.ltl.pattern.adapter.passport.pojo.ResultMsg;

public abstract class AbstractAdapter extends PassportService implements ILoginAdapter {
    protected ResultMsg loginForRegist(String username, String password){
        if (null == password){
            password="THIRD_EMPTY";
        }
        super.regist(username,password);
        return super.login(username, password);
    }
}
