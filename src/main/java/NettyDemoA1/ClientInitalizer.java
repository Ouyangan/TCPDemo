package NettyDemoA1;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @description:  initalizer
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class ClientInitalizer extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline channelPipeline = socketChannel.pipeline();
        channelPipeline.addLast( new MsgEncoder());
        channelPipeline.addLast(new MsgDecoder());
        channelPipeline.addLast(new ClientHandler());
    }
}
