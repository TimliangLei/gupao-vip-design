package com.dream.ltl.decorator.inter;

import java.util.ArrayList;
import java.util.List;

public class BasicNavigationBar implements INavigationBar {
    private List<String> menus= new ArrayList<>();
    {
        menus.add("问答");
        menus.add("文章");
        menus.add("精品课");
        menus.add("冒泡");
        menus.add("商城");
    }
    @Override
    public List<String> getBar() {
        return menus;
    }
}
