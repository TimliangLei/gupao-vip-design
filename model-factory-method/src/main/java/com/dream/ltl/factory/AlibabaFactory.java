package com.dream.ltl.factory;

import com.dream.ltl.api.IPay;
import com.dream.ltl.api.Ifactory;
import com.dream.ltl.service.Alibaba;

public class AlibabaFactory implements Ifactory {

    public IPay create() {
        IPay iPay = new Alibaba();
        return iPay;
    }
}
