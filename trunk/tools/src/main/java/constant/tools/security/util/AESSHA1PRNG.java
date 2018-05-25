package constant.tools.security.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AESSHA1PRNG {

    public static final Logger LOGGER = LoggerFactory.getLogger(AESSHA1PRNG.class);

    private String             password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * 加密
     * 
     * @param content
     *            需要加密的内容
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public String encrypt(String content) {
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(password.getBytes());
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes("UTF-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            String encryptResultStr = parseByte2HexStr(result);
            return encryptResultStr; // 加密
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (NoSuchPaddingException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (InvalidKeyException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (IllegalBlockSizeException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (BadPaddingException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 解密
     * 
     * @param encryptResultStr
     *            待解密内容
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public byte[] decrypt(String encryptResultStr) {
        try {
            byte[] content = parseHexStr2Byte(encryptResultStr);
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(password.getBytes());
            kgen.init(128, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (NoSuchPaddingException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (InvalidKeyException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (IllegalBlockSizeException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (BadPaddingException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 解密
     * 
     * @param content
     *            待解密内容
     * @return
     * @throws Exception
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public byte[] decrypt(byte[] content) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(password.getBytes());
        kgen.init(128, secureRandom);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
        byte[] result = cipher.doFinal(content);
        return result; // 加密
    }

    /**
     * 将二进制转换成16进制
     * 
     * @param buf
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     * 
     * @param hexStr
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
}
