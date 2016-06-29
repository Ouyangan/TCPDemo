package NettyDemoA1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class ClientHandler extends SimpleChannelInboundHandler<Protocol> {
    private static final Logger log = LoggerFactory.getLogger(ClientHandler.class);

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Protocol protocol) throws Exception {
        log.info("{}", protocol);
    }
}
