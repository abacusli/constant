package constant.tools.io.util;

import java.io.Closeable;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Closeables {

    private static final Logger LOGGER = LoggerFactory.getLogger(Closeables.class);

    /**
     * 
     * @param closeable
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static void closeQuietly(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
