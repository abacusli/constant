package constant.tools.security.util;

import java.nio.charset.Charset;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * @author Administrator
 *
 */
public class MD5 {

    /**
     * 
     * @param data
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String md5(String data) {
        return DigestUtils.md5Hex(data);
    }

    /**
     * 
     * @param data
     * @param encoding
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String md5(String data, String encoding) {
        return DigestUtils.md5Hex(data.getBytes(Charset.forName(encoding)));
    }
}
