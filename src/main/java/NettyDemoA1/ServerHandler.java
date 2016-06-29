package NettyDemoA1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @description: server business handler
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class ServerHandler extends SimpleChannelInboundHandler<Protocol> {

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
