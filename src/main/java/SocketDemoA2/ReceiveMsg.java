package SocketDemoA2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @description: 接收数据
 * @Author: ouyangan
 * @Date : 2016/6/27
 */
public class ReceiveMsg implements Runnable {
    private DataInputStream inputStream;
    private boolean isRunning = true;
    private String clientName;

    public ReceiveMsg(Socket client,String clientName) {
        this.clientName = clientName;
        try {
            this.inputStream = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closeStream(inputStream);
            e.printStackTrace();
        }
    }

    private void recive() {
        try {
            String s = inputStream.readUTF();
            System.out.println(clientName+"receive-->" + s);
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closeStream(inputStream);
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            recive();
        }
    }
}
