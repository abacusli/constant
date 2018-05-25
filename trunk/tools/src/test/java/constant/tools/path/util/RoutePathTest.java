package constant.tools.path.util;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class RoutePathTest extends TestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoutePathTest.class);

    public void testGenerateQrCode() {
        LOGGER.info(String.valueOf(Long.MAX_VALUE).length() + "");
        LOGGER.info((Long.MAX_VALUE) + "");
        LOGGER.info(RoutePath.routePath(Long.MAX_VALUE));
        LOGGER.info(RoutePath.routePath(123456789L));
        LOGGER.info(RoutePath.routePath(15002L));
        LOGGER.info(RoutePath.formatPath(15002L));

        File file = new File("./" + RoutePath.routePath(Long.MAX_VALUE));
        file.mkdirs();

        file = new File("./" + RoutePath.routePath(123456789L));
        file.mkdirs();
    }
}
