package constant.tools.ftp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class FTPClientUtilTest extends TestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(FTPClientUtilTest.class);

    public void testGenerateQrCode() {

        String ip = "192.168.2.116";
        int port = 2121;
        String password = "admin";
        String username = "admin";
        String remote = File.separator + "q" + File.separator + "q" + File.separator + "q.pem";
        InputStream local = null;
        try {
            local = new FileInputStream("C:\\Users\\Administrator\\Downloads\\t_user.sql");
            // local = new
            // ByteArrayInputStream("测试文件2\n测试文件1".getBytes("utf-8"));
            FTPClientUtil.renameOldFileAndStoreFile(ip, port, username, password, remote, local);
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (null != local) {
                try {
                    local.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }

        try {
            local = FTPClientUtil.retrieveFileStream(ip, port, username, password, remote);
            StringWriter stringWriter = new StringWriter();
            IOUtils.copy(local, stringWriter);
            LOGGER.info(stringWriter.toString());
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        if (null != local) {
            try {
                local.close();
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }

    }
}
