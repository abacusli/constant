package constant.tools.batis.bind;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DateBind {

    /**
     * tableHasCurrentDate = false 存在表，例如 table,table_yyyyMM,...;
     * tableHasCurrentDate = true 表table不存在，存在表，例如 table_yyyyMM,...;
     * 
     * @param table
     * @param start
     * @param tableHasCurrentDate
     * @param date
     * @return
     */
    public static String actualTable(String table, String start, boolean tableHasCurrentDate, Object date) {
        Map<String, Map<String, String>> map = calculateStart(table, start, tableHasCurrentDate, date, date);
        for (Entry<String, Map<String, String>> entry : map.entrySet()) {
            return entry.getValue().get(table);
        }
        if (null == date) {
            date = new Date();
        }
        Date d = (Date) date;
        String pattern = "yyyyMM";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String s = simpleDateFormat.format(d);

        StringBuilder builder = new StringBuilder();
        if (null != table) {
            builder.append(table);
        }
        builder.append('_');
        builder.append(s);
        return builder.toString();
    }

    /**
     * 存在表，例如 table,table_yyyyMM,...
     * 
     * @param table
     * @param start
     * @param date
     * @return
     */
    public static String actualTable(String table, String start, Object date) {
        boolean tableHasCurrentDate = false; // 存在表没有日期后缀，此表为当前写入数据表
        return actualTable(table, start, tableHasCurrentDate, date);
    }

    /**
     * tableHasCurrentDate = false 存在表，例如 table,table_yyyyMM,...;
     * tableHasCurrentDate = true 表table不存在，存在表，例如 table_yyyyMM,...;
     * 
     * @param tables
     * @param start
     * @param tableHasCurrentDate
     * @param startDate
     * @param endDate
     * @return
     */
    public static Map<String, Map<String, String>> calculateStart(String tables, String start,
            boolean tableHasCurrentDate, Object startDate, Object endDate) {
        Map<String, Map<String, String>> map = calculate(tables, tableHasCurrentDate, startDate, endDate);
        Set<String> set = map.keySet();
        String[] ss = set.toArray(new String[set.size()]);
        for (String s : ss) {
            if (start.compareTo(s) > 0) {
                map.remove(s);
            }
        }
        if (map.isEmpty()) {
            String pattern = "yyyyMM";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String key = simpleDateFormat.format(new Date());
            putTableMap(tables.split(","), key, key, tableHasCurrentDate, map);
        }
        return map;

    }

    /**
     * 存在表，例如 table,table_yyyyMM,...
     * 
     * @param tables
     * @param start
     * @param startDate
     * @param endDate
     * @return
     */
    public static Map<String, Map<String, String>> calculateStart(String tables, String start, Object startDate,
            Object endDate) {
        boolean tableHasCurrentDate = false; // 存在表没有日期后缀，此表为当前写入数据表
        return calculateStart(tables, start, tableHasCurrentDate, startDate, endDate);
    }

    public static Map<String, Map<String, String>> calculate(String tables, boolean tableHasCurrentDate,
            Object startDate, Object endDate) {
        String[] ts = tables.split(",");
        Date now = new Date();
        if (null == startDate) {
            startDate = now;
        }
        if (null == endDate) {
            endDate = now;
        }

        Date s = (Date) startDate;
        Date e = (Date) endDate;

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(s);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(e);

        int startYear = startCalendar.get(Calendar.YEAR);

        int endYear = endCalendar.get(Calendar.YEAR);

        if (startYear != endYear) {
            throw new IllegalArgumentException(MessageFormat.format("startYear {0} <> endYear {1}.",
                    String.valueOf(startYear), String.valueOf(endYear)));
        }

        int startMonth = startCalendar.get(Calendar.MONTH);

        int endMonth = endCalendar.get(Calendar.MONTH);

        if (startMonth > endMonth) {
            throw new IllegalArgumentException(
                    MessageFormat.format("startMonth {0} > endMonth {1}.", startMonth + 1, endMonth + 1));
        }

        Calendar nowCalendar = Calendar.getInstance();
        nowCalendar.setTime(now);

        int nowYear = nowCalendar.get(Calendar.YEAR);
        int nowMonth = nowCalendar.get(Calendar.MONTH);

        if (endYear > nowYear) {
            throw new IllegalArgumentException(MessageFormat.format("endYear {0} > nowYear {1}.",
                    String.valueOf(endYear), String.valueOf(nowYear)));
        }

        if (endYear == nowYear && endMonth > nowMonth) {
            throw new IllegalArgumentException(MessageFormat.format("endMonth {0} > nowMonth {1}  in year {2}.  ",
                    endMonth + 1, nowMonth + 1, String.valueOf(nowYear)));
        }

        StringBuilder nowBuilder = new StringBuilder(4 + 2);
        nowBuilder.append(nowYear);
        if (nowMonth < 9) {
            nowBuilder.append("0");
        }
        nowBuilder.append(nowMonth + 1);

        String nowM = nowBuilder.toString();

        Map<String, Map<String, String>> map = new LinkedHashMap<String, Map<String, String>>();
        for (int i = startMonth; i <= endMonth; i++) {
            nowBuilder.setLength(0);
            nowBuilder.append(startYear);
            if (i < 9) {
                nowBuilder.append("0");
            }
            nowBuilder.append(i + 1);
            String key = nowBuilder.toString();
            putTableMap(ts, key, nowM, tableHasCurrentDate, map);
        }
        return map;

    }

    /**
     * 存在表，例如 table,table_yyyyMM,...
     * 
     * @param tables
     * @param startDate
     * @param endDate
     * @return
     */
    public static Map<String, Map<String, String>> calculate(String tables, Object startDate, Object endDate) {
        boolean tableHasCurrentDate = false; // 存在表没有日期后缀，此表为当前写入数据表
        return calculate(tables, tableHasCurrentDate, startDate, endDate);
    }

    /**
     * tableHasCurrentDate = false 存在表，例如 table,table_yyyyMM,...;
     * tableHasCurrentDate = true 表table不存在，存在表，例如 table_yyyyMM,...;
     * 
     * @param ts
     * @param key
     * @param nowM
     * @param map
     * 
     */
    private static void putTableMap(String[] ts, String key, Object nowM, boolean tableHasCurrentDate,
            Map<String, Map<String, String>> map) {
        Map<String, String> tableMap = new LinkedHashMap<String, String>();
        for (String t : ts) {
            if (nowM.equals(key) && !tableHasCurrentDate) {
                tableMap.put(t, t);
            } else {
                tableMap.put(t, t + "_" + key);
            }
        }
        map.put(key, tableMap);
    }

}
