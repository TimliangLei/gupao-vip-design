package com.dream.ltl.app.singleton.threadLocal;

public class App {
    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        new Thread(new Runnable() {
            public void run() {

                System.out.println(ThreadLocalSingleton.getInstance());
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                System.out.println(ThreadLocalSingleton.getInstance());
            }
        }).start();
    }
}
