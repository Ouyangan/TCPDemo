package NettyDemoA1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @description: client handler
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class ClientHandler extends SimpleChannelInboundHandler<Protocol> {

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Protocol protocol) throws Exception {
        LogUtil.d(protocol);
    }
}
