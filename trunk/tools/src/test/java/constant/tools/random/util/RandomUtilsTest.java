package constant.tools.random.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class RandomUtilsTest extends TestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(RandomUtilsTest.class);

    public void testGenerateQrCode() {
        LOGGER.info("返回一个定长的随机字符串(只包含大小写字母、数字):" + RandomUtils.generateString(10));
        LOGGER.info("返回一个定长的随机纯字母字符串(只包含大小写字母):" + RandomUtils.generateLetterString(10));
        LOGGER.info("返回一个定长的随机纯小写字母字符串(只包含大小写字母):" + RandomUtils.generateLowerString(10));
        LOGGER.info("返回一个定长的随机纯小写字母字符串(只包含大大写字母):" + RandomUtils.generateUpperString(10));
        LOGGER.info("生成一个定长的纯0字符串:" + RandomUtils.generateZeroString(10));
        LOGGER.info("根据数字生成一个定长的字符串，长度不够前面补0:" + RandomUtils.toFixdLengthString(123, 10));
        int[] in = { 1, 2, 3, 4, 5, 6, 7 };
        LOGGER.info("每次生成的len位数都不相同:" + RandomUtils.getNotSimple(in, 5));

        LOGGER.info("每次生成的len位数都不相同:" + RandomUtils.generateNumber(5));

        LOGGER.info(RandomUtils.tradeNo());
    }
}
