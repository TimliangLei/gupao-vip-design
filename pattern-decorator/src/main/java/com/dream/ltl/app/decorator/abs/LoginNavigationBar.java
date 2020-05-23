package com.dream.ltl.app.decorator.abs;

import java.util.List;

public class LoginNavigationBar extends NavigationDecorator {

    public LoginNavigationBar(NavigationBar navigationBar) {
        super(navigationBar);
    }

    @Override
    List<String> getBar() {
        List<String> list = super.getBar();
        list.add("题库");
        list.add("作业");
        return list;
    }
}
