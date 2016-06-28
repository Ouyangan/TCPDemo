import SocketDemoA1.Client;
import SocketDemoA1.Server;
import SocketDemoA2.Message;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author: ouyangan
 * @Date : 2016/6/27
 */
public class SocketDemoA1Test {
    @Test
    public void demoA1Test() throws IOException, InterruptedException {
        new Thread(new Server()).start();
        for (int i = 0; i < 4; i++) {
            new Thread(new Client("client" + (i + 1))).start();
        }
        String a = null;
        System.out.println(a.length());
        while (true) {

        }

    }

    @Test
    public void demoA2Test() throws IOException, InterruptedException {
        new Thread(new SocketDemoA2.Server()).start();
        while (true) {

        }
    }

    @Test
    public void testName() throws Exception {
        Message a = new Message("aaaa", "data");
        new Thread(new SocketDemoA2.Client("client_a",a)).start();
        while (true) {

        }
    }
}
