package com.dream.ltl.singleton.redisSeriable;

import java.io.Serializable;

public class SeriableSingleton implements Serializable {
    public final static SeriableSingleton INSTANCE = new SeriableSingleton();

    private SeriableSingleton() {
    }

    public static SeriableSingleton getInstance(){return INSTANCE;}

    private Object readResolve(){
        return INSTANCE;
    }
}
