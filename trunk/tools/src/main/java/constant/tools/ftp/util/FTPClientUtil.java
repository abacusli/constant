package constant.tools.ftp.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author abacus.li
 *
 */
public class FTPClientUtil {

    public static final Logger LOGGER = LoggerFactory.getLogger(FTPClientUtil.class);

    /**
     * 创建目录层
     * 
     * @param ftpClient
     * @param pathnames
     * @throws IOException
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static void mkdirs(FTPClient ftpClient, String pathnames) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(pathnames, File.separator);
        String pathname = "";
        while (stringTokenizer.hasMoreElements()) {
            pathname = (String) stringTokenizer.nextElement();
            if (null == pathname || pathname.trim().isEmpty() || File.separator.equals(pathname)) {
                continue;
            }
            ftpClient.mkd(pathname);
            LOGGER.info("mkd->" + pathname + ", replyString:" + ftpClient.getReplyString());
            ftpClient.cwd(pathname);
            LOGGER.info("cwd->" + pathname + ", replyString:" + ftpClient.getReplyString());
        }
    }

    /**
     * 重命名旧文件并上传文件
     * 
     * @param ftpClient
     * @param remote
     * @param local
     * @throws IOException
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static void renameOldFileAndStoreFile(FTPClient ftpClient, String remote, InputStream local)
            throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss.S");
        String newRemote = remote + "." + dateFormat.format(new Date());
        ftpClient.rename(remote, newRemote);
        LOGGER.info("rename->" + remote + " to " + newRemote + ", replyString:" + ftpClient.getReplyString());
        storeFile(ftpClient, remote, local);
    }

    /**
     * 上传文件
     * 
     * @param ftpClient
     * @param remote
     * @param local
     * @throws IOException
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static void storeFile(FTPClient ftpClient, String remote, InputStream local) throws IOException {
        ftpClient.storeFile(remote, local);
    }

    /**
     * 从根目录读取文件
     * 
     * @param ftpClient
     * @param remote
     *            例如：/q/q/q.pem
     * @return
     * @throws IOException
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static InputStream retrieveFileStream(FTPClient ftpClient, String remote) throws IOException {
        ftpClient.cdup();
        return ftpClient.retrieveFileStream(remote);
    }

    /**
     * 
     * @param ip
     * @param port
     * @param username
     * @param password
     * @param remote
     *            例如：/q/q/q.pem
     * @return
     * @throws IOException
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static InputStream retrieveFileStream(String ip, int port, String username, String password, String remote)
            throws IOException {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ip, port);
            ftpClient.login(username, password);
            InputStream inputStream = retrieveFileStream(ftpClient, remote);
            return inputStream;
        } finally {
            ftpClient.logout();
        }
    }

    /**
     * 例如：/q/q/q.pem
     * 
     * @param ip
     * @param port
     * @param username
     * @param password
     * @param remote
     * @param local
     * @throws IOException
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static void renameOldFileAndStoreFile(String ip, int port, String username, String password, String remote,
            InputStream local) throws IOException {
        renameOldFileAndStoreFile(ip, port, username, password, remote, local, null);
    }

    /**
     * 
     * @param ip
     * @param port
     * @param username
     * @param password
     * @param remote
     *            例如：/q/q/q.pem
     * @param local
     * @param type
     * @return
     * @throws IOException
     * @author nicholas
     */
    public static void renameOldFileAndStoreFile(String ip, int port, String username, String password, String remote,
            InputStream local, String type) throws IOException {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ip, port);
            ftpClient.login(username, password);
            if (null != type) {
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            }
            ftpClient.cdup();
            int index = remote.lastIndexOf(File.separator);// File.separator
            String remoteFilename;
            if (index > 0) {
                String pathnames = remote.substring(0, index);
                remoteFilename = remote.substring(index + 1);
                mkdirs(ftpClient, pathnames);
            } else {
                remoteFilename = remote;
            }
            renameOldFileAndStoreFile(ftpClient, remoteFilename, local);
        } finally {
            ftpClient.logout();
        }
    }
}
