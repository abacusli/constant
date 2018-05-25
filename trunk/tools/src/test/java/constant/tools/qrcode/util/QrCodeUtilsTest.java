package constant.tools.qrcode.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class QrCodeUtilsTest extends TestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(QrCodeUtilsTest.class);

    public void testGenerateQrCode() {
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream("./lichaoyang.png");
            String text = "lichaoyang";
            QrCodeUtils.generateQrCode(text, outputStream);
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void testParseQrCode() {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream("./lichaoyang.png");
            String text = QrCodeUtils.parseQrCode(inputStream);
            Assert.assertEquals("lichaoyang", text);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

}
