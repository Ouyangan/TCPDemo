package NettyDemoA1;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @description: initalizer
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class DataMessageServerInitalizer extends ChannelInitializer<SocketChannel> {
    private static final DataEncoder ENCODER = new DataEncoder();
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(ENCODER);
        pipeline.addLast(new DataDecoder());
        pipeline.addLast(new DataMessageHandler());
    }
}
