package com.dream.ltl.pattern.adapter.passport.adapterv2.thirdadapter;

import com.dream.ltl.pattern.adapter.passport.pojo.ResultMsg;

public class LoginForPhoneAdapter extends AbstractAdapter {
    @Override
    public boolean support(Object o) {
        return o instanceof LoginForPhoneAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return super.loginForRegist(id,null);
    }
}
