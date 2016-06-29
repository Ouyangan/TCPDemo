package NettyDemoA1;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
@ChannelHandler.Sharable
public class ServerHandler extends SimpleChannelInboundHandler<Protocol> {
    private static final Logger log = LoggerFactory.getLogger(ServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Protocol msg) throws Exception {
        String type = msg.getProtocolHeader().getType();
        switch (type) {
            case Constant.PROTOCOL_HEADER_TYPE_A:
                LogUtil.i("get temperature:" + "28" + " do something");
                break;
            case Constant.PROTOCOL_HEADER_TYPE_B:
                LogUtil.i("get heart:" + "100" + " do something");
                break;
            case Constant.PROTOCOL_HEADER_TYPE_C:
                LogUtil.i("get beart:" + "16" + " do something");
                break;
            default:
                LogUtil.e("protocal format error");
                break;
        }
    }
}
