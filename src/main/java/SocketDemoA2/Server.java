package SocketDemoA2;

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

    public static void main(String[] args) {
        startServer();

    }

    public static void startServer() {

    }

    @Override
    public void run() {
        new Server().start();
    }

    public void start() {
        ServerSocket server = null;
        try {
            int port = 9000;
            server = new ServerSocket(port);
            System.out.println("start the server successful , port is:" + port + "\n");
            while (true) {
                new Thread(new CustomChanel(server.accept())).start();
            }
        } catch (IOException e) {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e1) {
                    System.out.println("server error");
                }
            }
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
                byte[] bytes = new byte[10240];
                inputStream.read(bytes);
                System.out.println("-->"+new String(bytes));
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
