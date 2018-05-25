package constant.tools.batis.bind;

public class IdBind {

    /**
     * 
     * @param id
     * @param size
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String actualTable(Number id, int size) {
        long l = id.longValue();
        long mod = l % size;
        String s = "0000" + mod;
        return s.substring(s.length() - 4, s.length());
    }

    /**
     * 
     * @param tableName
     * @param id
     * @return
     * @throws Exception
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String actualTable(String tableName, Number id, int size) throws Exception {
        String tab = tableName + "_" + actualTable(id, size);
        return tab;
    }

}
