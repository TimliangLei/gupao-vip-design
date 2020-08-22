package com.dream.ltl.mvcframework.webmvc.servlet;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class GPHandlerMapping {
//    URL
    private Pattern pattern;
//    Method
    private Method method;
    //    Method对应的实例对象
    private Object controller;

    public GPHandlerMapping(Pattern pattern, Method method, Object controller) {
        this.pattern = pattern;
        this.method = method;
        this.controller = controller;
    }



    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }
}
