package com.gupao;

import com.gupao.registry.IRegisterCenter;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectEncoder;
import org.jboss.netty.handler.codec.serialization.ObjectDecoder;

import java.util.HashMap;
import java.util.Map;

public class RpcServer {

    private IRegisterCenter registerCenter;
    private String serviceAddress;
    private Map<String,Object> handlerMap=new HashMap<String,Object>();

    public RpcServer(IRegisterCenter registerCenter,String serviceAddress){
        this.registerCenter=registerCenter;
        this.serviceAddress=serviceAddress;
    }

    public void publisher() {

        for (String serviceName : handlerMap.keySet()) {
            registerCenter.register(serviceName, serviceAddress);
        }
        try {
            EventLoopGroup bossGroup = new NioEventLoopGroup();
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel channel) throws Exception {
                    ChannelPipeline pipeline = channel.pipeline();
                    pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                    pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));
                    pipeline.addLast("encoder", new ObjectEncoder());
                    pipeline.addLast("decoder", new io.netty.handler.codec.serialization.ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));

                    //IO数据的交互  实际上在这里   Handler    很类似于Spring MVC  Handler
                    // 开发者在使用Netty的时候，只要定义一个个符合Netty标准的Handler即可
                    pipeline.addLast(new RpcServerHandler(handlerMap));
                }
            }).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true);
            String[] addrs = serviceAddress.split(":");
            String ip = addrs[0];
            int port = Integer.parseInt(addrs[1]);
            ChannelFuture future = bootstrap.bind(ip, port).sync();
            System.out.println("netty服务端启动成功，等待客户端的连接:");
            future.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void bind(Object... services) {

        for(Object service:services){
            RpcAnnotation annotation=service.getClass().getAnnotation(RpcAnnotation.class);
            String serviceName=annotation.value().getName();
            handlerMap.put(serviceName,service);
        }
    }

}
