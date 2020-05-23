package com.dream.ltl.app.decorator.abs;


public class App {
    public static void main(String[] args) {
//        todo 登陆前导航栏状态
        NavigationBar navigationBar = new BasicNavigationBar();
        System.out.println(navigationBar.getBar());
//        todo 登陆后导航栏状态
        NavigationBar navigationBar1 = new LoginNavigationBar(navigationBar);
        System.out.println(navigationBar1.getBar());
    }
}
