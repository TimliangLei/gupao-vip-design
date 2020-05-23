package com.dream.ltl.app.dynamicproxy.jdkproxy;

import com.dream.ltl.app.dynamicproxy.jdkproxy.pojo.Son;
import com.dream.ltl.app.dynamicproxy.jdkproxy.pojo.Son1;
import com.dream.ltl.app.dynamicproxy.jdkproxy.proxy.JDKMeipo;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        JDKMeipo proxy = new JDKMeipo();
        IPerson son1 = proxy.getIntance(new Son1());
        son1.findLove();

        IPerson son = proxy.getIntance(new Son());
        son.findLove();

        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{IPerson.class});
        try {
            FileOutputStream fos = new FileOutputStream("$Proxy0.class");
            fos.write(bytes);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
