package NettyDemoA1;

import java.io.Serializable;

/**
 * @description: data header
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class DataHeader implements Serializable {
    private int version;
    private int length;


    public DataHeader(int version, int length) {
        this.version = version;
        this.length = length;
    }

    public DataHeader() {
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "DataHeader{" +
                "version=" + version +
                ", length=" + length +
                '}';
    }
}
