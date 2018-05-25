package constant.tools.random.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author abacus.li
 *
 */
public class RandomUtils {

    public static final String ALLCHAR    = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String LETTERCHAR = "abcdefghijkllmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String NUMBERCHAR = "0123456789";

    /**
     * 
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String tradeNo() {
        String tradeNo = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        tradeNo = simpleDateFormat.format(new Date()) + generateNumber(6);
        return tradeNo;
    }

    /**
     * 返回一个定长的随机字符串(只包含大小写字母、数字)
     * 
     * @param length
     *            随机字符串长度
     * @return 随机字符串
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String generateString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 
     * @param length
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String generateNumber(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(NUMBERCHAR.charAt(random.nextInt(NUMBERCHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个定长的随机纯字母字符串(只包含大小写字母)
     * 
     * @param length
     *            随机字符串长度
     * @return 随机字符串
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String generateLetterString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(LETTERCHAR.charAt(random.nextInt(LETTERCHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个定长的随机纯小写字母字符串(只包含小写字母)
     * 
     * @param length
     *            随机字符串长度
     * @return 随机字符串
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String generateLowerString(int length) {
        return generateLetterString(length).toLowerCase();
    }

    /**
     * 返回一个定长的随机纯大写字母字符串(只包含大写字母)
     * 
     * @param length
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String generateUpperString(int length) {
        return generateLetterString(length).toUpperCase();
    }

    /**
     * 生成一个定长的纯0字符串
     * 
     * @param length
     *            字符串长度
     * @return 纯0字符串
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String generateZeroString(int length) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append('0');
        }
        return sb.toString();
    }

    /**
     * 根据数字生成一个定长的字符串，长度不够前面补0
     * 
     * @param num
     *            数字
     * @param fixdlenth
     *            字符串长度
     * @return 定长的字符串
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String toFixdLengthString(long num, int fixdlenth) {
        StringBuffer sb = new StringBuffer();
        String strNum = String.valueOf(num);
        if (fixdlenth - strNum.length() >= 0) {
            sb.append(generateZeroString(fixdlenth - strNum.length()));
        } else {
            throw new RuntimeException("Converts a digital " + num + " into a string of length " + fixdlenth
                    + ", where an exception occurs!");
        }
        sb.append(strNum);
        return sb.toString();
    }

    /**
     * 每次生成的len位数都不相同
     * 
     * @param param
     * @param len
     * @return 定长的数字
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static int getNotSimple(int[] param, int len) {
        Random random = new Random();
        for (int i = param.length; i > 1; i--) {
            int index = random.nextInt(i);
            int tmp = param[index];
            param[index] = param[i - 1];
            param[i - 1] = tmp;
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            result = result * 10 + param[i];
        }
        return result;
    }

}
