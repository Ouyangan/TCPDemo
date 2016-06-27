package SocketDemoA1;

import java.io.IOException;
import java.net.Socket;

/**
 * @description: 客户端
 * @Author: ouyangan
 * @Date : 2016/6/27
 */
public class Client implements Runnable {
    private String clientName;

    public Client(String clientName) {
        this.clientName = clientName;
    }

    private static void addClient(String clientName) throws IOException {
        Socket client = new Socket("127.0.0.1", 9000);
        new Thread(new SendMsg(client, clientName, clientName)).start();
        new Thread(new ReceiveMsg(client, clientName)).start();
    }

    @Override
    public void run() {
        try {
            addClient(clientName);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
