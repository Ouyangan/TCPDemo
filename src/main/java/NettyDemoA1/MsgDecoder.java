package NettyDemoA1;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @description: data decoder
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class MsgDecoder extends ByteToMessageDecoder {

    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

        if (byteBuf.readableBytes() > 4) {
            byte[] typeBytes = new byte[4];
            byteBuf.readBytes( new byte[4]);
            int length = byteBuf.readInt();
            ProtocolHeader protocolHeader = new ProtocolHeader(new String(typeBytes), length);
            byte[] bytes = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(bytes);
            Protocol protocol = new Protocol(protocolHeader, new String(bytes, "utf-8"));
            list.add(protocol);
            channelHandlerContext.flush();
        }

    }
}
