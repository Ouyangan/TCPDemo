package NettyDemoA1;

import org.junit.Test;
import org.xml.sax.ContentHandler;

/**
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class DataMessageClientTest {


    @Test
    public void startClient() throws Exception {
        DataMessage message = new DataMessage();
        DataHeader header = new DataHeader();
        String content = "aaa";
        message.setContent(content);
        header.setVersion(1);
        header.setLength(content.length());
        message.setDataHeader(header);
        DataMessageClient.startClient("127.0.0.1",8888,message);

        while (true) {

        }
    }

}