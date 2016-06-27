package SocketDemoA1;

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
    private boolean isRunning =true;
    private String msg;
    private String clientName;

    public SendMsg(Socket client,String msg,String name) {
        this.msg = msg;
        this.clientName=name;
        try {
            this.outputStream = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closeStream(outputStream);
        }
    }

    private void send() {
        try {
            outputStream.writeUTF(msg);
            outputStream.flush();
        } catch (IOException e) {
            isRunning = false;
            CloseUtil.closeStream(outputStream);
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        int i=0;
        while (isRunning) {
            send();
            i++;
            if (i == 4) {
                break;
            }
        }
    }
}
