package SocketDemoA2;

import org.junit.Test;


/**
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class ClientTest {
    @Test
    public void testClient(){
        new Thread(new SocketDemoA2.Client("client_a ", Message.createATypeProtocol("aaaa28"))).start();
        new Thread(new SocketDemoA2.Client("client_b ",Message.createATypeProtocol("bbbb100"))).start();
        new Thread(new SocketDemoA2.Client("client_c ",Message.createATypeProtocol("cccc16"))).start();
        new Thread(new SocketDemoA2.Client("client_c ",new Message("hhhha","sdasdasdasdasd"))).start();
        while (true) {
        }
    }
}