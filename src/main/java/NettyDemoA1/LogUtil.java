package NettyDemoA1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author:ouyangan
 * @date:29/6/2016
 * @description:
 */
public class LogUtil {
    private static final Logger log = LoggerFactory.getLogger(LogUtil.class);
    public static void i(Object... objectses) {
        if (objectses.length > 0) {
            for (Object o : objectses) {
                log.info("NettyDemoA1---------------->{}", o.toString());
            }
        }
    }
    public static void d(Object... objectses) {
        if (objectses.length > 0) {
            for (Object o : objectses) {
                log.debug("NettyDemoA1---------------->{}", o.toString());
            }
        }
    }
    public static void e(Object... objectses) {
        if (objectses.length > 0) {
            for (Object o : objectses) {
                log.error("NettyDemoA1---------------->{}", o.toString());
            }
        }
    }
}
