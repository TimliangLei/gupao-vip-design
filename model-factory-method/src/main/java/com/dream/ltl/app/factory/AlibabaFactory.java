package com.dream.ltl.app.factory;

import com.dream.ltl.app.api.IPay;
import com.dream.ltl.app.api.Ifactory;
import com.dream.ltl.app.mvc.service.Alibaba;

public class AlibabaFactory implements Ifactory {

    public IPay create() {
        IPay iPay = new Alibaba();
        return iPay;
    }
}
