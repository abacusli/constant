package constant.tools.math.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class MathUtilTest extends TestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MathUtilTest.class);

    public void testGenerateQrCode() {
        LOGGER.info(MathUtils.multiply100HalfUp("900.00"));
    }
}
