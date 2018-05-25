
package constant.tools.date.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtils {

    private static final Logger LOGGER                  = LoggerFactory.getLogger(DateUtils.class);

    public static String        YYYY_MM_DD              = "yyyy-MM-dd";

    public static String        YYYY_Y_MM_M_DD_D        = "yyyy年MM月dd日";

    public static String        YYYY_MM_DD_HH_MM        = "yyyy-MM-dd HH:mm";

    public static String        YYYY_MM                 = "yyyy-MM";

    public static String        YYYY                    = "yyyy";

    public static String        YYYY_MM_DD_HH_MM_SS     = "yyyy-MM-dd HH:mm:ss";

    public static String        YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

    public static String        YYYYMMDD                = "yyyyMMdd";

    public static String        YYYYMMDDHHMMSSSSS       = "yyyyMMddHHmmssSSS";

    public static String        YYYYMMDDHHMMSS          = "yyyyMMddHHmmss";

    public static String        YYYYMM                  = "yyyyMM";

    /**
     * 大于
     */
    public static final String  COMPARE_TYPE_GT         = "GT";

    /**
     * 大于等于
     */
    public static final String  COMPARE_TYPE_GTE        = "GTE";

    /**
     * 不等于
     */
    public static final String  COMPARE_TYPE_NE         = "NE";

    /**
     * 日期验证复杂正则
     */
    public static String        DATE_REG                = "([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-9])))";

    /**
     * 日期验证简单正则
     */
    public static String        DATE_REG_SIMPLE         = "^\\d{4}-\\d{2}-\\d{2}$";

    /**
     * 默认的日期间隔符
     */
    public static String        DEFAULT_SEPERATOR       = "-";

    /**
     * 
     * @param pattern
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static SimpleDateFormat getSimpleDateFormat(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    /**
     * 
     * @param pattern
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String dateToString(String pattern) {
        return getSimpleDateFormat(pattern).format(new Date());
    }

    /**
     * 
     * @param date
     * @param pattern
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String dateToString(Date date, String pattern) {
        return getSimpleDateFormat(pattern).format(date);
    }

    /**
     * 
     * @param date
     * @param pattern
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static Date stringToDate(String date, String pattern) {
        if (StringUtils.isEmpty(pattern)) {
            return null;
        }
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        Date result = null;
        try {
            SimpleDateFormat simpleDateFormat = getSimpleDateFormat(pattern);
            result = simpleDateFormat.parse(date);
            String actual = simpleDateFormat.format(result);
            if (!date.equals(actual)) {
                LOGGER.error("Pattern[" + pattern + "] error at date[" + date + "] actual[" + actual + "] .");
            }
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    public static Date startTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date endTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

}
