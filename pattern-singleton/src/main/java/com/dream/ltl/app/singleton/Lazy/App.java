package com.dream.ltl.app.singleton.Lazy;

public class App {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
//            new Thread(new Runnable() {
//                public void run() {
//                    System.out.println(LazyDoubleCheckSingleton.getInstance());
//                }
//            }).start();
//            new Thread(new Runnable() {
//                public void run() {
//                    System.out.println(LazyDoubleCheckSingleton.getInstance());
//                }
//            }).start();
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(LazyStaticInnerClassSingleton.getInstance());
                }
            }).start();
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(LazyStaticInnerClassSingleton.getInstance());
                }
            }).start();

            Thread.sleep(1000);
        }
    }
}
