package com.dream.ltl.app.decorator.abs;

import java.util.ArrayList;
import java.util.List;

public class BasicNavigationBar extends NavigationBar {

    private List<String> menus= new ArrayList<>();
    {
        menus.add("问答");
        menus.add("文章");
        menus.add("精品课");
        menus.add("冒泡");
        menus.add("商城");
    }
    @Override
    List<String> getBar() {
        return menus;
    }
}
