package com.dream.ltl;

import com.dream.ltl.api.Ifactory;


public class App {
    public static void main(String[] args) throws Exception {
        Ifactory ifactory = (Ifactory) Class.forName("com.dream.ltl.factory.AlibabaFactory").newInstance();
        ifactory.create().pay();
    }
}
