package NettyTcpDemoA2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @Author: ouyangan
 * @Date : 2016/6/29
 */
public class MsgDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        Msg msg = new Msg();
        int length = in.readInt();
        int i = in.readableBytes();

    }
}
