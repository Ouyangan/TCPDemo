package NettyDemoA1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class Client {
    private static final Logger log = LoggerFactory.getLogger(Client.class);
    public static void startClient(String ip, int port, Protocol protocol) {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ClientInitalizer());
        try {
            Channel ch = bootstrap.connect(ip, port).sync().channel();
            ch.writeAndFlush(protocol);
            ch.close();
        } catch (InterruptedException e) {
            LogUtil.e("client error:{}", e.toString());
        } finally {
            group.shutdownGracefully();
        }
    }
}
