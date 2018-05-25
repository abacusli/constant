
package constant.tools.batis.bind;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.ibatis.scripting.xmltags.OgnlCache;

import junit.framework.TestCase;

public class DateBindTest extends TestCase {

    public void testActualTable() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Object date = format.parse("20170030");
        String r = DateBind.actualTable("t_table", "199707", date);
        System.out.println(r);
    }

    public void testCalculateStart() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Object endDate = format.parse("20170630");
        Object startDate = format.parse("20170630");
        Map<String, Map<String, String>> r = DateBind.calculateStart("t_table,t_table1", "201701", startDate, endDate);
        System.out.println(r);
    }

    public void testCalculate() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Object endDate = format.parse("20170730");
        Object startDate = format.parse("20170130");
        Map<String, Map<String, String>> r = DateBind.calculate("t_table,t_table1", startDate, endDate);
        System.out.println(r);
    }

    public void testCalculateByOgnlCache() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Object endDate = format.parse("20170631");
        Object startDate = format.parse("20170331");
        ;

        String expression = "@constant.tools.batis.bind.DateBind@calculate('t_table,t_table1',startDate ,endDate)";
        Map<String, Object> root = new LinkedHashMap<String, Object>();
        root.put("startDate", startDate);
        root.put("endDate", endDate);
        Object r = OgnlCache.getValue(expression, root);
        System.out.println(r);

    }

}
