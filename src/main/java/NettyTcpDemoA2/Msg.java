package NettyTcpDemoA2;

/**
 * @Author: ouyangan
 * @Date : 2016/6/29
 */
public class Msg {
    private String header;
    private int length;
    private String content;

    public Msg(String header, String content) {
        this.header = header;
        this.content = content;
        if (content == null || content.length() == 0) {
            throw new NullPointerException("数据不能为空");
        } else {
            this.length = content.length();
        }

    }

    public Msg() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
