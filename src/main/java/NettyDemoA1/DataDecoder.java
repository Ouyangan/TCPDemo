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
public class DataDecoder extends ByteToMessageDecoder {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(DataEncoder.class);

    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int version = byteBuf.readInt();
        int length = byteBuf.readInt();
        DataHeader dataHeader = new DataHeader(version, length);
        log.debug("ananan:{}", dataHeader.toString());
        log.debug("ananan:{}", dataHeader.toString());
        byte[] content = byteBuf.readBytes(byteBuf.readableBytes()).asReadOnly().array();
        log.debug("ananan:{}", new String(content));
        DataMessage dataMessage = new DataMessage(dataHeader, new String(content));
        list.add(dataMessage);
    }
}
