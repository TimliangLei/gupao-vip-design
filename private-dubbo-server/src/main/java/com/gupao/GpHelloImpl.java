package com.gupao;

@RpcAnnotation(IGpHello.class)
public class GpHelloImpl implements IGpHello{

    public String sayHello(String msg) {
        return "From Server：I'm "+msg;
    }

}
