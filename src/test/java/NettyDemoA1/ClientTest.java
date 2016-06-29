package NettyDemoA1;

import org.junit.Test;

/**
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class ClientTest {

    @Test
    public void startClient() throws Exception {
        Client.startClient("127.0.0.1",9960,Protocol.createTypeA("aaaa28"));
        Client.startClient("127.0.0.1",9960,Protocol.createTypeB("bbbb100"));
        Client.startClient("127.0.0.1",9960,Protocol.createTypeC("cccc16"));
        Client.startClient("127.0.0.1",9960,Protocol.createTypeError("ananan","ananan"));
        while (true) {
        }
    }

}