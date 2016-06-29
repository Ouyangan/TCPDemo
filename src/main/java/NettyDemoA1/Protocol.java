package NettyDemoA1;

import java.io.Serializable;

/**
 * @description: data conent
 * @Author: ouyangan
 * @Date : 2016/6/28
 */
public class Protocol implements Serializable {

    private ProtocolHeader protocolHeader;
    private String content;

    public Protocol(ProtocolHeader protocolHeader, String content) {
        if (content.equals(null) || content.length() == 0) {
            throw new IllegalArgumentException("content can not be empty");
        }
        this.protocolHeader = protocolHeader;
        this.content = content;
    }

    public Protocol(String content) {
        if (content.equals(null) || content.length() == 0) {
            throw new IllegalArgumentException("content can not be empty");
        }
        this.content = content;
    }

    public Protocol() {
    }

    public ProtocolHeader getProtocolHeader() {
        return protocolHeader;
    }

    public void setProtocolHeader(ProtocolHeader protocolHeader) {
        this.protocolHeader = protocolHeader;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Protocol{" +
                "protocolHeader=" + protocolHeader +
                ", content='" + content + '\'' +
                '}';
    }


    public static Protocol createTypeA(String content){
        if (content.equals(null) || content.length() == 0) {
            throw new IllegalArgumentException("content can not be empty");
        }
        Protocol protocol = new Protocol(content);
        ProtocolHeader protocolHeader = new ProtocolHeader(Constant.PROTOCOL_HEADER_TYPE_A,protocol.getContent().length());
        protocol.setProtocolHeader(protocolHeader);
        return protocol;
    }
    public static Protocol createTypeB(String content){
        if (content.equals(null) || content.length() == 0) {
            throw new IllegalArgumentException("content can not be empty");
        }
        Protocol protocol = new Protocol(content);
        ProtocolHeader protocolHeader = new ProtocolHeader(Constant.PROTOCOL_HEADER_TYPE_B,protocol.getContent().length());
        protocol.setProtocolHeader(protocolHeader);
        return protocol;
    }
    public static Protocol createTypeC(String content){
        if (content.equals(null) || content.length() == 0) {
            throw new IllegalArgumentException("content can not be empty");
        }
        Protocol protocol = new Protocol(content);
        ProtocolHeader protocolHeader = new ProtocolHeader(Constant.PROTOCOL_HEADER_TYPE_C,protocol.getContent().length());
        protocol.setProtocolHeader(protocolHeader);
        return protocol;
    }


 public static Protocol createTypeError(String type,String content){
     if (content.equals(null) || content.length() == 0) {
         throw new IllegalArgumentException("content can not be empty");
     }
        Protocol protocol = new Protocol(content);
        ProtocolHeader protocolHeader = new ProtocolHeader(type,protocol.getContent().length());
        protocol.setProtocolHeader(protocolHeader);
        return protocol;
    }




}
