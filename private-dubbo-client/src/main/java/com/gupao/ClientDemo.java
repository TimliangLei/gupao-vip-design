package com.gupao;

import com.gupao.proxy.RpcClientProxy;
import com.gupao.registry.IServiceDiscovery;
import com.gupao.registry.ServiceDiscoveryImpl;

public class ClientDemo {
    public static void main(String[] args) {
        IServiceDiscovery serviceDiscovery=new ServiceDiscoveryImpl();

        String url=serviceDiscovery.discover("com.gupao.IGpHello");

        // 客户端进行远程调用服务端，可以无感知像是调用本地方法一样
        RpcClientProxy rpcClientProxy=new RpcClientProxy(serviceDiscovery);


        IGpHello iGpHello=rpcClientProxy.create(IGpHello.class);


        System.out.println(iGpHello.sayHello("Jack"));
    }
}
