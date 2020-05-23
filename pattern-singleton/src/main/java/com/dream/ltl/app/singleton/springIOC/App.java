package com.dream.ltl.app.singleton.springIOC;

public class App {
    public static void main(String[] args) throws Exception {
//        Object o = ContainerSingleton.getInstance("com.dream.ltl.singleton.pojo.Pojo");
//        System.out.println(o);
        while (true) {
            new Thread(new Runnable() {
                public void run() {

                    try {
                        System.out.println(ContainerSingleton.getInstance("com.dream.ltl.singleton.pojo.Pojo"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                public void run() {
                    try {
                        System.out.println(ContainerSingleton.getInstance("com.dream.ltl.singleton.pojo.Pojo"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            Thread.sleep(1000);
        }

    }
}
