package constant.tools.desensitize.util;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author abacus.li
 *
 */
public class DesensitizeUtils {

    /**
     * only retain last four chars
     * 
     * @param bankCardNo
     *            bank card number
     * @return desensitized bank card number
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String bankCardDesensitization(String bankCardNo) {
        if (StringUtils.isBlank(bankCardNo)) {
            return null;
        }
        return StringUtils.leftPad(StringUtils.right(bankCardNo, 4), StringUtils.length(bankCardNo), "*");
    }

    /**
     * Only Keep the last four characters
     * 
     * @param idCardNo
     *            identity card number to desensitise
     * @return desensitized identity card number
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String idCardNoDesensitization(String idCardNo) {
        if (StringUtils.isBlank(idCardNo)) {
            return null;
        }
        String num = StringUtils.right(idCardNo, 4);
        return StringUtils.leftPad(num, StringUtils.length(idCardNo), "*");
    }

    /**
     * Keep the last and first four characters
     * 
     * @param mobile
     *            mobile
     * @return desensitized mobile
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String mobileDesensitization(String mobile) {
        if (StringUtils.isBlank(mobile)) {
            return "";
        }
        return StringUtils.left(mobile, 3).concat(StringUtils.removeStart(
                StringUtils.leftPad(StringUtils.right(mobile, 4), StringUtils.length(mobile), "*"), "***"));
    }

    /**
     * Desensitise the name, only KEEP FIRST NAME
     * 
     * @param fullName
     *            full name on identity card
     * @return desensitized name
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String nameDesensitization(String fullName) {
        if (StringUtils.isBlank(fullName)) {
            return "";
        }
        String name = StringUtils.left(fullName, 1);
        return StringUtils.rightPad(name, StringUtils.length(fullName), "*");
    }
}
