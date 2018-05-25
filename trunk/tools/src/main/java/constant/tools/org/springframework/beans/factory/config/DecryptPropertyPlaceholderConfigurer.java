package constant.tools.org.springframework.beans.factory.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import constant.tools.security.util.AESCodec;

/**
 * 
 * @author abacus.li
 *
 */
public class DecryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DecryptPropertyPlaceholderConfigurer.class);

    private String              secretKey;

    /**
     * 
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * 
     * @param secretKey
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if (isEncryptPropertyValue(propertyName)) {
            try {
                return AESCodec.decrypt(propertyValue, null == secretKey ? AESCodec.SECRET_KEY : secretKey);
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
                return propertyValue;
            }
        } else {
            return super.convertProperty(propertyName, propertyValue);
        }
    }

    /**
     * 
     * @param propertyName
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    protected boolean isEncryptPropertyValue(String propertyName) {
        return propertyName.startsWith("encrypt_") || propertyName.startsWith("encrypt.");
    }
}
