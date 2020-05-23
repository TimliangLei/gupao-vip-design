package com.dream.ltl.app.factroy;

import com.dream.ltl.app.api.ICheck;
import com.dream.ltl.app.api.IPay;
import com.dream.ltl.app.pojo.SysConfig;

public interface IPaymentFactory {
    IPay pay(String type);
    ICheck check(String type);
    void deal(SysConfig sysConfig);
}
