package NettyDemoA1;

import org.junit.Test;

/**
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class DataServerTest {

    @Test
    public void startServer() throws Exception {
        DataServer.startServer(8888);
        while (true) {

        }
    }
}