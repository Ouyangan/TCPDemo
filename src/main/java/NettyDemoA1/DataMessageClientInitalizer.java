package NettyDemoA1;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class DataMessageClientInitalizer extends ChannelInitializer<SocketChannel> {
    private static final DataEncoder ENCODER = new DataEncoder();

    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline channelPipeline = socketChannel.pipeline();
        channelPipeline.addLast(ENCODER);
        channelPipeline.addLast(new DataDecoder());
        channelPipeline.addLast(new DataMessageClientHandler());
    }
}
