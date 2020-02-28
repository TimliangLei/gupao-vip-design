package com.gupao;

import com.gupao.registry.IServiceDiscovery;
import com.gupao.registry.ServiceDiscoveryImpl;


public class Test {
    public static void main(String[] args) {
        IServiceDiscovery iServiceDiscovery=new ServiceDiscoveryImpl();
        System.out.println(iServiceDiscovery.discover("com.gupao.IJack"));
    }
}
