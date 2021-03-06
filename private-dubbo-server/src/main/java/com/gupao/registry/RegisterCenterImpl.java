package com.gupao.registry;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class RegisterCenterImpl implements IRegisterCenter {

    private CuratorFramework curatorFramework;

    {
        curatorFramework = CuratorFrameworkFactory.builder().
                connectString(ZkConfig.CONNECTION_STR).sessionTimeoutMs(4000).
                retryPolicy(new ExponentialBackoffRetry(1000, 10)).build();
        curatorFramework.start();
    }

    /*
        com.gupao.IGupaoHello
            ip
     */
    public void register(String serviceName, String serviceAddress) {

        //   /registrys/com.gupao.IGupaoHello
        String servicePath = ZkConfig.ZK_REGISTER_PATH + "/" + serviceName;   //构建关于服务名称的地址

        try {
            //   /registrys/com.gupao.IGupaoHello     CreateMode.PERSISTENT
            if (curatorFramework.checkExists().forPath(servicePath) == null) {
                curatorFramework.create().creatingParentsIfNeeded().
                        withMode(CreateMode.PERSISTENT).forPath(servicePath, "0".getBytes());
            }
            //  /registrys/com.gupao.IGupaoHello/serviceAddress1
            //  /registrys/com.gupao.IGupaoHello/serviceAddress2
            //  /registrys/com.gupao.IGupaoHello/serviceAddress3
            //   CreateMode.EPHEMERAL
            String addressPath = servicePath + "/" + serviceAddress;
            String rsNode = curatorFramework.create().withMode(CreateMode.EPHEMERAL).
                    forPath(addressPath, "0".getBytes());
            System.out.println("服务注册成功:" + rsNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
