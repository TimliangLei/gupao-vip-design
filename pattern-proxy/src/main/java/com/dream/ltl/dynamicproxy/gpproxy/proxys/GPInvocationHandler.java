package com.dream.ltl.dynamicproxy.gpproxy.proxys;

import java.lang.reflect.Method;

public interface GPInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
