package com.dream.ltl.mvcframework.beans;

import lombok.Data;

@Data
public class GPBeanWrapper {
    private Object wrapperInstance;
    private Class<?> wrapperClass;
    public GPBeanWrapper(Object instance) {
        this.wrapperInstance = instance;
        wrapperClass = instance.getClass();
    }
}
