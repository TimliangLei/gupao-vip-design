package com.dream.ltl.app.decorator.inter;

import java.util.List;

public class LoginNavigationBar implements INavigationBar {

    private INavigationBar navigationBar = null;

    public LoginNavigationBar(INavigationBar navigationBar) {
        this.navigationBar = navigationBar;
    }

    @Override
    public List<String> getBar() {
        List<String> list = navigationBar.getBar();
        list.add("题库");
        list.add("作业");
        return list;
    }
}
