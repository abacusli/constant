package constant.tools.image.validation.util;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

public class VerifyCodeUtilsTest extends TestCase {

    public void testGenerateVerifyCode() throws IOException {
        File dir = new File("./verifies");
        int w = 200, h = 80;
        for (int i = 0; i < 50; i++) {
            String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
            File file = new File(dir, verifyCode + ".jpg");
            VerifyCodeUtils.outputImage(w, h, file, verifyCode);
        }
    }
}
