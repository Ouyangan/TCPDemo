package NettyDemoA1;

import java.io.Serializable;

/**
 * @description: data header
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class ProtocolHeader implements Serializable {
    private String type;
    private int length;

    public ProtocolHeader(String type, int length) {
        this.length = length;
        this.type = type;
    }

    public ProtocolHeader(String type) {
        this.type = type;
    }

    public ProtocolHeader() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "ProtocolHeader{" +
                "type=" + type +
                ", length=" + length +
                '}';
    }
}
