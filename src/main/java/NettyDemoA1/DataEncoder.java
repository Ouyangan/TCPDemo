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
public class DataEncoder extends MessageToByteEncoder<DataMessage> {
    private static final Logger log = LoggerFactory.getLogger(DataEncoder.class);

    protected void encode(ChannelHandlerContext channelHandlerContext, DataMessage dataMessage, ByteBuf byteBuf) throws Exception {
        DataHeader dataHeader = dataMessage.getDataHeader();
        byteBuf.writeInt(dataHeader.getVersion());
        byteBuf.writeInt(dataMessage.getContent().length());
        log.debug("ananan{}", dataMessage.toString());
        byteBuf.writeBytes(dataMessage.getContent().getBytes());
    }
}
