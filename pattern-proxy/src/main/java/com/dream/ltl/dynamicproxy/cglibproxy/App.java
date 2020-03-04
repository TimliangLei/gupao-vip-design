package com.dream.ltl.dynamicproxy.cglibproxy;

import com.dream.ltl.dynamicproxy.jdkproxy.pojo.Son;
import net.sf.cglib.core.DebuggingClassWriter;

public class App {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"G:\\gupaoedu-vip-design\\pattern-proxy");
        Son son = (Son) new CGlibMeipo().getIntance(Son.class);
        son.findLove();
    }
}
