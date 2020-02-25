package com.dream.ltl.factory;

import com.dream.ltl.api.IPay;
import com.dream.ltl.api.Ifactory;
import com.dream.ltl.service.Visa;

public class VisaFactory implements Ifactory {
    public IPay create() {
        IPay iPay = new Visa();
        return iPay;
    }
}
