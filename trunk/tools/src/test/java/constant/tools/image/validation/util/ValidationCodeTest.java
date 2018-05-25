package constant.tools.image.validation.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import junit.framework.TestCase;

public class ValidationCodeTest extends TestCase {

    public void testGetValidationCode() throws IOException {
        File dir = new File("./verifies1");
        for (int i = 0; i < 50; i++) {
            File file = new File(dir, "1.jpg");
            OutputStream outputStream = new FileOutputStream(file);
            String verifyCode = ValidationCode.getValidationCode(outputStream);
            outputStream.close();
            file = new File(dir, "1.jpg");
            file.renameTo(new File(dir, verifyCode + ".jpg"));
        }
    }
}
