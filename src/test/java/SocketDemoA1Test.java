import SocketDemoA1.Client;
import SocketDemoA1.Server;
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
            new Thread(new Client("client"+(i+1))).start();
        }
        while (true) {

        }
    }

}
