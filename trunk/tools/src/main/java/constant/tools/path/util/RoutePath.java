package constant.tools.path.util;

import java.io.File;

public class RoutePath {

    /**
     * 路由目录算法，共5层，每层文件名长度为4
     * 如long最大值9223372036854775807处理后为/0922/3372/0368/5477/5807
     * 
     * @param id
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String routePath(Long id) {
        if (null == id || id < 0) {
            return null;
        }
        return routePath(String.valueOf(id));
    }

    /**
     * 
     * @param id
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String routePath(String id) {
        if (null == id) {
            return null;
        }
        StringBuilder sb = new StringBuilder(39);
        sb.append("00000000000000000000").append(id);
        sb.delete(0, sb.length() - 20);
        for (int i = 0, loop = 0; i < 20; i = i + 4, loop++) {
            sb.insert(i + loop, File.separatorChar);
        }
        return sb.toString();

    }

    /**
     * 
     * @param id
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String formatPath(Long id) {
        if (null == id || id < 0) {
            return null;
        }
        return formatPath(String.valueOf(id));
    }

    /**
     * 
     * @param id
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String formatPath(String id) {
        if (null == id) {
            return null;
        }
        StringBuilder sb = new StringBuilder(39);
        sb.append("00000000000000000000").append(id);
        sb.delete(0, sb.length() - 20);
        return sb.toString();
    }

}
