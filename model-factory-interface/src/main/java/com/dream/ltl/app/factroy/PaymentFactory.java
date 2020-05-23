package com.dream.ltl.app.factroy;

import com.dream.ltl.app.api.ICheck;
import com.dream.ltl.app.api.IPay;
import com.dream.ltl.app.pojo.SysConfig;

public class PaymentFactory implements IPaymentFactory {
    public IPay pay(String type) {
        try {
            return (IPay) Class.forName(type).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ICheck check(String type) {
        try {
            return (ICheck) Class.forName(type).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deal(SysConfig sysConfig) {
        ICheck check = check(sysConfig.getCheckClassPath());
        if (check!=null){
            check.check();
        }
        IPay pay = pay(sysConfig.getPayClassPath());
        if (pay != null){
            pay.pay();
        }
    }
}
