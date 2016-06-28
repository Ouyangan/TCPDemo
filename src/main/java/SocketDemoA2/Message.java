package SocketDemoA2;

/**
 * @author:ouyangan
 * @date:28/6/2016
 * @description: 消息类
 */
public class Message {

    private String header;
    private int length;
    private String msg;

    public Message(String header, String msg) {
        this.header = header;
        this.msg = msg;
        if (msg == null || msg.length() == 0) {
            throw new NullPointerException("数据不能为空");
        } else {
            this.length = msg.length();
        }
    }


    @Override
    public String toString() {
        return "Message{" +
                "header='" + header + '\'' +
                ", length=" + length +
                ", msg='" + msg + '\'' +
                '}';
    }

    public String getHeader() {
        return header;
    }

    public int getLength() {
        return length;
    }

    public String getMsg() {
        return msg;
    }
}
