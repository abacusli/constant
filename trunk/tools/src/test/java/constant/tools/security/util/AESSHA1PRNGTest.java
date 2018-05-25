package constant.tools.security.util;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class AESSHA1PRNGTest extends TestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(AESSHA1PRNGTest.class);

    public void testGenerateQrCode() {
        String data = "lichaoyang";
        try {
            AESSHA1PRNG aessha1prng = new AESSHA1PRNG();
            String password = data;
            aessha1prng.setPassword(password);
            String encrypt = aessha1prng.encrypt(data);
            LOGGER.info(encrypt);
            Assert.assertEquals(data, new String(aessha1prng.decrypt(encrypt)));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
