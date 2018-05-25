package constant.tools.security.util;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class AESCodecTest extends TestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(AESCodecTest.class);

    public void testGenerateQrCode() {
        String data = "lichaoyang";
        try {
            // FVQtve+6nRcp2aqVdhXvmA==
            // FVQtve+6nRcp2aqVdhXvmA==
            String encrypt = AESCodec.encrypt(data, AESCodec.SECRET_KEY);
            LOGGER.info(encrypt);
            Assert.assertEquals(data, AESCodec.decrypt(encrypt, AESCodec.SECRET_KEY));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void testDecrypt() {
        String encrypt = "+VdksQ+GutW46E+79Z8PuBlvCyu7HKSM++makt6R22s=";
        try {
            System.out.println(AESCodec.decrypt(encrypt, "7D1aBvl/dUR8djbvjw7WJA=="));
            LOGGER.info(AESCodec.decrypt(encrypt, "7D1aBvl/dUR8djbvjw7WJA=="));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
