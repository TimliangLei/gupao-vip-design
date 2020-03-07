package com.dream.ltl.dynamicproxy.jdkproxy.proxy;


import com.dream.ltl.dynamicproxy.jdkproxy.IPerson;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKMeipo implements InvocationHandler {
    private IPerson target;
    public IPerson getIntance(IPerson target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
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
