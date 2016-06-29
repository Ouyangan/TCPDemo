package NettyDemoA1;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: data encoder
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class MsgEncoder extends MessageToByteEncoder<Protocol> {

    private static final Logger log = LoggerFactory.getLogger(MsgEncoder.class);

    protected void encode(ChannelHandlerContext channelHandlerContext, Protocol protocol, ByteBuf byteBuf) throws Exception {
        ProtocolHeader protocolHeader = protocol.getProtocolHeader();
        byteBuf.writeBytes(protocolHeader.getType().getBytes());
        byteBuf.writeInt(protocol.getContent().length());
        log.debug("ananan{}", protocol.toString());
        byteBuf.writeBytes(protocol.getContent().getBytes());
        channelHandlerContext.flush();
    }
}
