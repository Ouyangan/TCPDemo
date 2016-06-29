package NettyDemoA1;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @description: data encoder
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class MsgEncoder extends MessageToByteEncoder<Protocol> {


    protected void encode(ChannelHandlerContext channelHandlerContext, Protocol protocol, ByteBuf byteBuf) throws Exception {
        ProtocolHeader protocolHeader = protocol.getProtocolHeader();
        byteBuf.writeBytes(protocolHeader.getType().getBytes());
        byteBuf.writeInt(protocol.getContent().length());
        LogUtil.d( protocol.toString());
        byteBuf.writeBytes(protocol.getContent().getBytes());
        channelHandlerContext.flush();
    }
}
