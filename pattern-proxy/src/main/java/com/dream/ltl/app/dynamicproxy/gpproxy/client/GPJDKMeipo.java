package com.dream.ltl.app.dynamicproxy.gpproxy.client;

import com.dream.ltl.app.dynamicproxy.gpproxy.proxys.GPClassLoader;
import com.dream.ltl.app.dynamicproxy.gpproxy.proxys.GPInvocationHandler;
import com.dream.ltl.app.dynamicproxy.gpproxy.proxys.GPProxy;


import java.lang.reflect.Method;

public class GPJDKMeipo implements GPInvocationHandler {
    private IPerson target;
    public IPerson getIntance(IPerson target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return (IPerson) GPProxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        befor();
        Object result = method.invoke(this.target,args);
        after();
        return result;
    }

    private void after() {
        System.out.println("双方同意，开始交往");
    }

    private void befor() {
        System.out.println("我是媒婆，收集到你的需求，开始物色");
    }
}
