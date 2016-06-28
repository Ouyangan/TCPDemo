package SocketDemoA2;

import java.io.Closeable;
import java.io.IOException;

/**
 * @description: 工具类
 * @Author: ouyangan
 * @Date : 2016/6/27
 */
public class CloseUtil {
    public static void closeStream(Closeable... io) {
        for (Closeable c : io) {
            if (null != c) {
                try {
                    c.close();
                } catch (IOException e) {
                    System.out.println("io流关闭异常");
                    e.printStackTrace();
                }
            }
        }

    }
}
