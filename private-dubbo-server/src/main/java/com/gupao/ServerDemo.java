package com.gupao;

import com.gupao.registry.IRegisterCenter;
import com.gupao.registry.RegisterCenterImpl;

public class ServerDemo {
    public static void main(String[] args) {
        IGpHello iGpHello = new GpHelloImpl();
        IRegisterCenter registerCenter = new RegisterCenterImpl();

        // 服务的注册 && Netty监听
        RpcServer rpcServer=new RpcServer(registerCenter,"192.168.10.1:8888");
        rpcServer.bind(iGpHello);
        rpcServer.publisher();
    }
}
