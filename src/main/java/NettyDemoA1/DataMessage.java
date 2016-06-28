package NettyDemoA1;

import java.io.Serializable;

/**
 * @description: data conent
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class DataMessage implements Serializable {

    private DataHeader dataHeader;
    private String content;

    public DataMessage(DataHeader dataHeader, String content) {
        this.dataHeader = dataHeader;
        this.content = content;
    }

    public DataMessage() {
    }

    public DataHeader getDataHeader() {
        return dataHeader;
    }

    public void setDataHeader(DataHeader dataHeader) {
        this.dataHeader = dataHeader;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DataMessage{" +
                "dataHeader=" + dataHeader +
                ", content='" + content + '\'' +
                '}';
    }
}
