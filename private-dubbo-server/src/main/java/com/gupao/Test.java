package com.gupao;

import com.gupao.registry.IRegisterCenter;
import com.gupao.registry.RegisterCenterImpl;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {

        IRegisterCenter iRegisterCenter=new RegisterCenterImpl();
        iRegisterCenter.register("com.gupao.IJack","192.169.10.5:9090");
        System.in.read();
    }

}
