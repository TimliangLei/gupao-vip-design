package com.dream.ltl.dynamicproxy.gpproxy.client;



import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        GPJDKMeipo proxy = new GPJDKMeipo();
        IPerson son1 = proxy.getIntance(new Son1());
        son1.findLove("李");



//        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{IPerson.class});
//        try {
//            FileOutputStream fos = new FileOutputStream("$Proxy0.class");
//            fos.write(bytes);
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
