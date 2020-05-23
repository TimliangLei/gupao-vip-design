package com.dream.ltl.app.pattern.adapter.passport.adapterv2.thirdadapter;

import com.dream.ltl.app.pattern.adapter.passport.pojo.ResultMsg;

public interface ILoginAdapter {
    boolean support(Object o);
    ResultMsg login(String id, Object adapter);

}
