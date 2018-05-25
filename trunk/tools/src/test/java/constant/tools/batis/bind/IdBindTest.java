package constant.tools.batis.bind;

import java.text.ParseException;

import junit.framework.TestCase;

public class IdBindTest extends TestCase {

    public void testActualTable() throws ParseException {
        String s = IdBind.actualTable(123456, 1024);
        System.out.println(s);
    }

}
