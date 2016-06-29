package NettyDemoA1;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @description: data decoder
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class MsgDecoder extends ByteToMessageDecoder {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(MsgEncoder.class);

    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        String type = null;
        if (byteBuf.readableBytes() > 4) {
            byte[] typeBytes = new byte[4];
            byteBuf.readBytes(typeBytes);
            type = new String(typeBytes);
            int length = byteBuf.readInt();
            ProtocolHeader protocolHeader = new ProtocolHeader(type, length);
            byte[] bytes = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(bytes);
            Protocol protocol = new Protocol(protocolHeader, new String(bytes, "utf-8"));
            list.add(protocol);
            channelHandlerContext.flush();
        }

    }
}
