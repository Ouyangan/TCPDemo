package NettyDemoA1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class DataMessageHandler extends SimpleChannelInboundHandler {
    private static final Logger log = LoggerFactory.getLogger(DataMessageHandler.class);


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.debug("{}", msg);
    }
}
