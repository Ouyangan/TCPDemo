package SocketDemoA2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class ServerTest {
    @Test
    public void testServer(){
        new Thread(new SocketDemoA2.Server()).start();

        while (true) {
        }
    }
}