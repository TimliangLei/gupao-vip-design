package com.dream.ltl.app;

import com.dream.ltl.app.api.Ifactory;


public class App {
    public static void main(String[] args) throws Exception {
        Ifactory ifactory = (Ifactory) Class.forName("com.dream.ltl.app.factory.AlibabaFactory").newInstance();
        ifactory.create().pay();
    }
}
