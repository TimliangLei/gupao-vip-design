package com.dream.ltl.app.pattern.adapter.passport.adapterv2;

import com.dream.ltl.app.pattern.adapter.passport.adapterv2.thirdadapter.LoginForQQAdapter;

public class App {
    public static void main(String[] args) {
        IPassportForThird adapter = new PassportForThirdAdapter();
        adapter.processLogin("wrwerwqwer", LoginForQQAdapter.class);

    }
}
