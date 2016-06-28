package NettyDemoA1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class DataMessageClientHandler extends SimpleChannelInboundHandler<DataMessage> {
    private static final Logger log = LoggerFactory.getLogger(DataMessageClientHandler.class);

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DataMessage dataMessage) throws Exception {
        log.info("{}", dataMessage);
    }
}
