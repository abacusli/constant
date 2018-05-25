package constant.tools.properties.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesUtils.class);

    private Properties          properties;

    private String              file;

    public void init() {
        properties = new Properties();
        InputStream in = null;
        try {
            in = PropertiesUtils.class.getResourceAsStream(file);
            properties.load(in);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * 
     * @param property
     * @param defaultValue
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public String getProperty(String property, String defaultValue) {
        String v = properties.getProperty(property);
        if (null == v) {
            return defaultValue;
        }
        return v;
    }

}
