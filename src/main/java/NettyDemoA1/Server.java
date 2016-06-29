package NettyDemoA1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @description: server client
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class Server {
    public static void startServer(int port) {
        EventLoopGroup parentGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.option(ChannelOption.SO_BACKLOG, 124);
        serverBootstrap.group(parentGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ServerInitalizer());
        try {
            Channel channel = serverBootstrap.bind(port).sync().channel();
            LogUtil.i("server start successful, binding port is :" + port);
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            LogUtil.e("server error:{}", e.toString());
        } finally {
            parentGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
