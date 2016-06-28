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

//        // TODO: 2016/6/29
/**
 *
 * io.netty.handler.codec.DecoderException: java.nio.ReadOnlyBufferException
 at io.netty.handler.codec.ByteToMessageDecoder.callDecode(ByteToMessageDecoder.java:442)
 at io.netty.handler.codec.ByteToMessageDecoder.channelRead(ByteToMessageDecoder.java:248)
 at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348)
 at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:334)
 at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:326)
 at io.netty.channel.DefaultChannelPipeline$HeadContext.channelRead(DefaultChannelPipeline.java:1320)
 at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348)
 at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:334)
 at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:905)
 at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:123)
 at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:563)
 at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:504)
 at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:418)
 at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:390)
 at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:742)
 at io.netty.util.concurrent.DefaultThreadFactory$DefaultRunnableDecorator.run(DefaultThreadFactory.java:145)
 at java.lang.Thread.run(Thread.java:745)
 Caused by: java.nio.ReadOnlyBufferException: null
 at io.netty.buffer.ReadOnlyByteBuf.array(ReadOnlyByteBuf.java:96)
 at NettyDemoA1.DataDecoder.decode(DataDecoder.java:24)
 at io.netty.handler.codec.ByteToMessageDecoder.callDecode(ByteToMessageDecoder.java:411)
 ... 16 common frames omitted
 */
        DataMessage dataMessage = new DataMessage(dataHeader, new String(content));
        list.add(dataMessage);
    }
}
