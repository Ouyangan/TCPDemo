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
                String s = inputStream.readUTF();
                String header = s.substring(0, 4);
                int length = Integer.parseInt(s.substring(4, 5));
                String msg = s.substring(5);
                switch (header) {
                    case "aaaa":
                        System.out.println("get temperature:" + "28" + " do something");
                        break;
                    case "bbbb":
                        System.out.println("get heart:" + "100" + " do something");
                        break;
                    case "cccc":
                        System.out.println("get beart:" + "16" + " do something");
                        break;
                    default:
                        break;
                }
                System.out.println("....");
            } catch (IOException e) {
                isRunning = false;
                CloseUtil.closeStream(inputStream, outputStream);
            } catch (NumberFormatException e) {
                isRunning = false;
                CloseUtil.closeStream(inputStream, outputStream);
                System.out.println("数据格式异常,请核对");
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
