package com.dream.ltl.decorator.inter;

public class App {
    public static void main(String[] args) {
        INavigationBar navigationBar = new BasicNavigationBar();
        System.out.println(navigationBar.getBar());

        INavigationBar navigationBar1 = new LoginNavigationBar(navigationBar);
        System.out.println(navigationBar1.getBar());
    }
}
