package com.example.netty.marshalling;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author eddie.lee
 * @ProjectName netty-demo
 * @Package com.example.netty.marshalling
 * @ClassName Server
 * @description
 * @date created in 2021-03-26 16:03
 * @modified by
 */
@Slf4j
public class Server {

    public static void main(String[] args) {
        EventLoopGroup bGroup = new NioEventLoopGroup(1);
        EventLoopGroup wGroup = new NioEventLoopGroup();

        // 建造者模式
        ServerBootstrap sb = new ServerBootstrap();
        sb.group(bGroup, wGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    /**
                     * This method will be called once the {@link Channel} was registered. After the method returns this instance
                     * will be removed from the {@link ChannelPipeline} of the {@link Channel}.
                     *
                     * @param sc the {@link Channel} which was registered.
                     * @throws Exception is thrown if an error occurs. In that case it will be handled by
                     *                   {@link #exceptionCaught(ChannelHandlerContext, Throwable)} which will by default close
                     *                   the {@link Channel}.
                     */
                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception {
                        sc.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
                        sc.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
                        sc.pipeline().addLast(new ServerHandler());
                    }
                });

        try {
            ChannelFuture cf = sb.bind(8765).sync();
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            //e.printStackTrace();
            log.error("Server Main: {}", String.valueOf(e));
        } finally {
            bGroup.shutdownGracefully();
            wGroup.shutdownGracefully();
        }
    }

}
