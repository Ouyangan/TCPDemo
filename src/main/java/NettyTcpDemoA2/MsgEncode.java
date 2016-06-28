package NettyTcpDemoA2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Author: ouyangan
 * @Date : 2016/6/29
 */
public class MsgEncode extends MessageToByteEncoder<Msg> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Msg msg, ByteBuf out) throws Exception {
        out.writeInt(msg.getLength());
        out.writeBytes(msg.getHeader().getBytes());
        out.writeBytes(msg.getContent().getBytes());
        ctx.flush();
    }
}
