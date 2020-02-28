package com.gupao.registry;

import com.gupao.loadbalance.LoadBalance;
import com.gupao.loadbalance.RandomLoadBalance;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.ArrayList;
import java.util.List;

public class ServiceDiscoveryImpl implements IServiceDiscovery {

    List<String> repos=new ArrayList<String>();

    private CuratorFramework curatorFramework;
    public ServiceDiscoveryImpl(){
        curatorFramework= CuratorFrameworkFactory.builder().
                connectString(ZkConfig.CONNECTION_STR).sessionTimeoutMs(4000).
                retryPolicy(new ExponentialBackoffRetry(1000,10)).build();
        curatorFramework.start();
    }

    @Override
    public String discover(String serviceName) {
        // 根据服务名称拿到urls
        String path=ZkConfig.ZK_REGISTER_PATH+"/"+serviceName;
        try {
            // 为何会拿到urls呢？
            repos = curatorFramework.getChildren().forPath(path);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //通过zk节点的watch机制实现监听的功能
        registerWatch(path);

        //负载均衡算法
        LoadBalance loadBalance=new RandomLoadBalance();
        return loadBalance.select(repos);
    }

    private void registerWatch(final String path) {
        PathChildrenCache childrenCache=new PathChildrenCache(curatorFramework,path,true);
        PathChildrenCacheListener pathChildrenCacheListener=new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                repos=curatorFramework.getChildren().forPath(path);
            }
        };
        childrenCache.getListenable().addListener(pathChildrenCacheListener);
        try {
            childrenCache.start();
        } catch (Exception e) {
            throw new RuntimeException("注册PathChild Watcher 异常"+e);
        }
    }

}
