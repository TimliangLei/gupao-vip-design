package com.dream.ltl.factroy;

import com.dream.ltl.api.ICheck;
import com.dream.ltl.api.IPay;
import com.dream.ltl.pojo.SysConfig;

public interface IPaymentFactory {
    IPay pay(String type);
    ICheck check(String type);
    void deal(SysConfig sysConfig);
}
