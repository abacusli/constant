package constant.tools.uuid.util;

import java.util.UUID;

public class UuidUtils {

    /**
     * 
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String getId() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String id = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23)
                + str.substring(24);
        return id;
    }
}
