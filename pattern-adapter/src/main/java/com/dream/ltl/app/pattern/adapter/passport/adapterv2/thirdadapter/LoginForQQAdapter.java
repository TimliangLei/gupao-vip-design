package com.dream.ltl.app.pattern.adapter.passport.adapterv2.thirdadapter;


import com.dream.ltl.app.pattern.adapter.passport.pojo.ResultMsg;

public class LoginForQQAdapter extends AbstractAdapter {
    @Override
    public boolean support(Object o) {
        return o instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return super.loginForRegist(id,null);
    }
}
