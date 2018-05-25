package constant.tools.httpclient.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import constant.tools.httpclient.util.https.DefaultHostnameVerifier;
import constant.tools.httpclient.util.https.DefaultSSLSocketFactory;
import constant.tools.io.util.Closeables;

public class SimpleHttpClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleHttpClient.class);

    /**
     * 
     * @param serverUrl
     * @param content
     * @param encoding
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String doPost(String serverUrl, String content, String encoding) {
        String result = null;
        HttpURLConnection urlConn = null;
        OutputStream out = null;
        InputStream in = null;
        InputStream inError = null;
        try {
            URL url = new URL(serverUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            filter(urlConn, encoding);
            if ("https".equalsIgnoreCase(url.getProtocol())) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlConn;
                httpsURLConnection.setSSLSocketFactory(new DefaultSSLSocketFactory());
                httpsURLConnection.setHostnameVerifier(new DefaultHostnameVerifier());
            }
            urlConn.connect();
            out = urlConn.getOutputStream();
            IOUtils.write(content, out, encoding);
            out.flush();
            in = urlConn.getInputStream();
            if (null != in) {
                result = IOUtils.toString(in, encoding);
            } else {
                inError = urlConn.getErrorStream();
                LOGGER.error(IOUtils.toString(inError, encoding));
            }
        } catch (Exception e) {
            LOGGER.error(
                    "Access [serverUrl:" + serverUrl + ",content:" + content + ",encoding:" + encoding + "] error .");
            LOGGER.error(e.getMessage(), e);
        } finally {
            try {
                if (urlConn != null) {
                    urlConn.disconnect();
                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
            Closeables.closeQuietly(out);
            Closeables.closeQuietly(in);
            Closeables.closeQuietly(inError);
        }
        return result;
    }

    /**
     * 
     * @param serverUrl
     * @param content
     * @param encoding
     * @param filter
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String doPost(String serverUrl, String content, String encoding, HttpURLConnectionFilter filter) {
        String result = null;
        HttpURLConnection urlConn = null;
        OutputStream out = null;
        InputStream in = null;
        InputStream inError = null;
        try {
            URL url = new URL(serverUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            filter(urlConn, encoding);
            if (null != filter) {
                filter.filter(urlConn);
            }
            if ("https".equalsIgnoreCase(url.getProtocol())) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlConn;
                httpsURLConnection.setSSLSocketFactory(new DefaultSSLSocketFactory());
                httpsURLConnection.setHostnameVerifier(new DefaultHostnameVerifier());
            }
            urlConn.connect();
            out = urlConn.getOutputStream();
            IOUtils.write(content, out, encoding);
            out.flush();
            in = urlConn.getInputStream();
            if (null != in) {
                result = IOUtils.toString(in, encoding);
            } else {
                inError = urlConn.getErrorStream();
                LOGGER.error(IOUtils.toString(inError, encoding));
            }
        } catch (Exception e) {
            LOGGER.error(
                    "Access [serverUrl:" + serverUrl + ",content:" + content + ",encoding:" + encoding + "] error .");
            LOGGER.error(e.getMessage(), e);
        } finally {
            try {
                if (urlConn != null) {
                    urlConn.disconnect();
                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
            Closeables.closeQuietly(out);
            Closeables.closeQuietly(in);
            Closeables.closeQuietly(inError);
        }
        return result;
    }

    private static void filter(HttpURLConnection urlConn, String encoding) throws ProtocolException {
        urlConn.setConnectTimeout(60000);// 连接超时时间
        urlConn.setReadTimeout(60000);// 读取结果超时时间
        urlConn.setRequestMethod("POST");
        urlConn.setDoOutput(true);
        urlConn.setDoInput(true);
        urlConn.setUseCaches(false);// 取消缓存
        urlConn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=" + encoding);
    }

    public static interface HttpURLConnectionFilter {

        void filter(HttpURLConnection urlConn);
    }

    /**
     * 
     * @param serverUrl
     * @param content
     * @param encoding
     * @return
     * @author abacus.li
     * @date 2017年8月29日
     *
     */
    public static String doPostQueryString(String serverUrl, String content, String encoding) {
        String result = null;
        HttpURLConnection urlConn = null;
        OutputStream out = null;
        InputStream in = null;
        InputStream inError = null;
        try {
            URL url = new URL(serverUrl + "?" + content);
            urlConn = (HttpURLConnection) url.openConnection();
            filter(urlConn, encoding);
            if ("https".equalsIgnoreCase(url.getProtocol())) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlConn;
                httpsURLConnection.setSSLSocketFactory(new DefaultSSLSocketFactory());
                httpsURLConnection.setHostnameVerifier(new DefaultHostnameVerifier());
            }
            urlConn.connect();
            // out = urlConn.getOutputStream();
            // IOUtils.write(content, out, encoding);
            // out.flush();
            in = urlConn.getInputStream();
            if (null != in) {
                result = IOUtils.toString(in, encoding);
            } else {
                inError = urlConn.getErrorStream();
                LOGGER.error(IOUtils.toString(inError, encoding));
            }
        } catch (Exception e) {
            LOGGER.error(
                    "Access [serverUrl:" + serverUrl + ",content:" + content + ",encoding:" + encoding + "] error .");
            LOGGER.error(e.getMessage(), e);
        } finally {
            try {
                if (urlConn != null) {
                    urlConn.disconnect();
                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
            Closeables.closeQuietly(out);
            Closeables.closeQuietly(in);
            Closeables.closeQuietly(inError);
        }
        return result;
    }
}
