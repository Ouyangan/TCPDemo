package SocketDemoA2;

import java.io.IOException;
import java.net.Socket;

/**
 * @description: 客户端
 * @Author: ouyangan
 * @Date : 2016/6/27
 */
public class Client implements Runnable {
    private String clientName;
    private Message message;

    private static void addClient(String clientName, Message message) throws IOException {
        Socket client = new Socket("127.0.0.1", 9000);
        new Thread(new SendMsg(client, message, clientName)).start();
        new Thread(new ReceiveMsg(client, clientName)).start();
    }

    @Override
    public void run() {
        try {
            addClient(clientName,message);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public Client(String clientName, Message message) {
        this.clientName = clientName;
        this.message = message;
    }
}
