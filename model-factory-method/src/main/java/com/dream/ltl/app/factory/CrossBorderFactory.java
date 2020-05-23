package com.dream.ltl.app.factory;

import com.dream.ltl.app.api.IPay;
import com.dream.ltl.app.api.Ifactory;
import com.dream.ltl.app.mvc.service.CrossBorder;

public class CrossBorderFactory implements Ifactory {
    private static CrossBorderFactory instance = null;

    public IPay create() {
        return new CrossBorder();
    }
}
