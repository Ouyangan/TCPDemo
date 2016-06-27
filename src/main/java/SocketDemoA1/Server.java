package SocketDemoA1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: 服务器端
 * @Author: ouyangan
 * @Date : 2016/6/27
 */
public class Server implements Runnable {

    @Override
    public void run() {
        new Server().start();
    }

    public static void main(String[] args) {
        startServer();

    }

    public static void startServer() {

    }
    public void start() {
        try {
            int port=9000;
            ServerSocket server = new ServerSocket(port);
            System.out.println("");
            System.out.println("start the server successful , port is:"+port+"\n");
            while (true) {
                new Thread(new CustomChanel(server.accept())).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private class CustomChanel implements Runnable {

        private DataInputStream inputStream;
        private DataOutputStream outputStream;
        private boolean isRunning = true;

        CustomChanel(Socket server) {
            try {
                this.inputStream = new DataInputStream(server.getInputStream());
                this.outputStream = new DataOutputStream(server.getOutputStream());
            } catch (IOException e) {
                isRunning = false;
                CloseUtil.closeStream(inputStream, outputStream);
                e.printStackTrace();
            }

        }

        private void send() {
            try {
                outputStream.writeUTF("服务器返回数据");
                outputStream.flush();
            } catch (IOException e) {
                isRunning = false;
                CloseUtil.closeStream(inputStream, outputStream);
                e.printStackTrace();
            }
        }

        private void receive() {
            try {
                String msg = inputStream.readUTF();
                System.out.println("server receive-->"+msg);
            } catch (IOException e) {
                isRunning = false;
                CloseUtil.closeStream(inputStream, outputStream);
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            while (isRunning) {
                send();
                receive();
            }
        }
    }
}
