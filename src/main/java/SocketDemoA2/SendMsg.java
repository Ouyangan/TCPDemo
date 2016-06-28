package SocketDemoA2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @description: 发送数据
 * @Author: ouyangan
 * @Date : 2016/6/27
 */
public class SendMsg implements Runnable {
    private DataOutputStream outputStream;
    private boolean isRunning = true;
    private Message message;
    private String clientName;

    public SendMsg(Socket client, Message message, String name) {
        this.message = message;
        this.clientName = name;
        try {
            this.outputStream = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closeStream(outputStream);
        }
    }

    private void send() {
        try {
            outputStream.writeUTF(message.getHeader() + message.getLength() + message.getMsg());
            outputStream.flush();
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closeStream(outputStream);
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        int i = 0;
        while (isRunning) {
            i++;
            send();
            if (i == 1) {
                break;
            }
        }
    }
}
