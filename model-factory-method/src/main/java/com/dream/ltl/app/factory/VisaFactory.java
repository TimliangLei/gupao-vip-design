package com.dream.ltl.app.factory;

import com.dream.ltl.app.api.IPay;
import com.dream.ltl.app.api.Ifactory;
import com.dream.ltl.app.mvc.service.Visa;

public class VisaFactory implements Ifactory {
    public IPay create() {
        IPay iPay = new Visa();
        return iPay;
    }
}
