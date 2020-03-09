package com.dream.ltl.decorator.abs;

import java.util.List;

public abstract class NavigationDecorator extends NavigationBar {

    private NavigationBar navigationBar;

    public NavigationDecorator(NavigationBar navigationBar) {
        this.navigationBar = navigationBar;
    }

    @Override
    List<String> getBar() {
        return navigationBar.getBar();
    }
}
