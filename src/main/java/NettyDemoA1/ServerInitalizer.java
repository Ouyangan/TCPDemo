package NettyDemoA1;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @description: initalizer
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class ServerInitalizer extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast( new MsgEncoder());
        pipeline.addLast(new MsgDecoder());
        pipeline.addLast(new ServerHandler());
    }
}
