package com.dream.ltl.factory;

import com.dream.ltl.api.IPay;
import com.dream.ltl.api.Ifactory;
import com.dream.ltl.service.CrossBorder;

public class CrossBorderFactory implements Ifactory {
    private static CrossBorderFactory instance = null;

    public IPay create() {
        return new CrossBorder();
    }
}
