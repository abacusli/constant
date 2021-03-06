package constant.tools.project.xml;

public class Webxml {

    public static String generate(String name) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        stringBuffer.append(
                "<web-app version=\"3.0\" xmlns=\"http://java.sun.com/xml/ns/javaee\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");
        stringBuffer.append(
                " xsi:schemaLocation=\"http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd\">\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <context-param>\n");
        stringBuffer.append("  <param-name>webAppRootKey</param-name>\n");
        stringBuffer.append("  <param-value>" + name + "</param-value>\n");
        stringBuffer.append(" </context-param>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <context-param>\n");
        stringBuffer.append("  <param-name>contextConfigLocation</param-name>\n");
        stringBuffer.append("  <param-value>classpath:" + name + ".applicationContext.xml</param-value>\n");
        stringBuffer.append(" </context-param>\n");
        stringBuffer.append(" <listener>\n");
        stringBuffer
                .append("  <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>\n");
        stringBuffer.append(" </listener>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <context-param>\n");
        stringBuffer.append("  <param-name>logbackConfigLocation</param-name>\n");
        stringBuffer.append("  <param-value>classpath:" + name + ".logback.xml</param-value>\n");
        stringBuffer.append(" </context-param>\n");
        stringBuffer.append(" <listener>\n");
        stringBuffer.append("  <listener-class>ch.qos.logback.ext.spring.web.LogbackConfigListener</listener-class>\n");
        stringBuffer.append(" </listener>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <filter>\n");
        stringBuffer.append("  <filter-name>springSessionRepositoryFilter</filter-name>\n");
        stringBuffer.append("  <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>\n");
        stringBuffer.append(" </filter>\n");
        stringBuffer.append(" <filter-mapping>\n");
        stringBuffer.append("  <filter-name>springSessionRepositoryFilter</filter-name>\n");
        stringBuffer.append("  <url-pattern>/*</url-pattern>\n");
        stringBuffer.append(" </filter-mapping>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <filter>\n");
        stringBuffer.append("  <filter-name>characterEncodingFilter</filter-name>\n");
        stringBuffer.append("  <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>\n");
        stringBuffer.append("  <init-param>\n");
        stringBuffer.append("   <param-name>encoding</param-name>\n");
        stringBuffer.append("   <param-value>UTF-8</param-value>\n");
        stringBuffer.append("  </init-param>\n");
        stringBuffer.append(" </filter>\n");
        stringBuffer.append(" <filter-mapping>\n");
        stringBuffer.append("  <filter-name>characterEncodingFilter</filter-name>\n");
        stringBuffer.append("  <url-pattern>/*</url-pattern>\n");
        stringBuffer.append(" </filter-mapping>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <!-- <filter>\n");
        stringBuffer.append("  <filter-name>sitemesh</filter-name>\n");
        stringBuffer.append("  <filter-class>com.opensymphony.module.sitemesh.filter.PageFilter</filter-class>\n");
        stringBuffer.append("  </filter>\n");
        stringBuffer.append("  <filter-mapping>\n");
        stringBuffer.append("  <filter-name>sitemesh</filter-name>\n");
        stringBuffer.append("  <url-pattern>/*</url-pattern>\n");
        stringBuffer.append("  </filter-mapping> -->\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <servlet>\n");
        stringBuffer.append("  <servlet-name>" + name + "</servlet-name>\n");
        stringBuffer.append("  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>\n");
        stringBuffer.append("  <load-on-startup>1</load-on-startup>\n");
        stringBuffer.append(" </servlet>\n");
        stringBuffer.append(" <servlet-mapping>\n");
        stringBuffer.append("  <servlet-name>" + name + "</servlet-name>\n");
        stringBuffer.append("  <url-pattern>/</url-pattern>\n");
        stringBuffer.append(" </servlet-mapping>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <session-config>\n");
        stringBuffer.append("  <session-timeout>30</session-timeout>\n");
        stringBuffer.append(" </session-config>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <welcome-file-list>\n");
        stringBuffer.append("  <welcome-file>index.html</welcome-file>\n");
        stringBuffer.append(" </welcome-file-list>\n");
        stringBuffer.append("\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <servlet-mapping>\n");
        stringBuffer.append("  <servlet-name>default</servlet-name>\n");
        stringBuffer.append("  <url-pattern>*.html</url-pattern>\n");
        stringBuffer.append(" </servlet-mapping>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <servlet-mapping>\n");
        stringBuffer.append("  <servlet-name>default</servlet-name>\n");
        stringBuffer.append("  <url-pattern>*.htm</url-pattern>\n");
        stringBuffer.append(" </servlet-mapping>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <servlet-mapping>\n");
        stringBuffer.append("  <servlet-name>default</servlet-name>\n");
        stringBuffer.append("  <url-pattern>*.css</url-pattern>\n");
        stringBuffer.append(" </servlet-mapping>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <servlet-mapping>\n");
        stringBuffer.append("  <servlet-name>default</servlet-name>\n");
        stringBuffer.append("  <url-pattern>*.js</url-pattern>\n");
        stringBuffer.append(" </servlet-mapping>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <servlet-mapping>\n");
        stringBuffer.append("  <servlet-name>default</servlet-name>\n");
        stringBuffer.append("  <url-pattern>*.gif</url-pattern>\n");
        stringBuffer.append(" </servlet-mapping>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <servlet-mapping>\n");
        stringBuffer.append("  <servlet-name>default</servlet-name>\n");
        stringBuffer.append("  <url-pattern>*.jpg</url-pattern>\n");
        stringBuffer.append(" </servlet-mapping>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <servlet-mapping>\n");
        stringBuffer.append("  <servlet-name>default</servlet-name>\n");
        stringBuffer.append("  <url-pattern>*.svg</url-pattern>\n");
        stringBuffer.append(" </servlet-mapping>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <servlet-mapping>\n");
        stringBuffer.append("  <servlet-name>default</servlet-name>\n");
        stringBuffer.append("  <url-pattern>*.png</url-pattern>\n");
        stringBuffer.append(" </servlet-mapping>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <servlet-mapping>\n");
        stringBuffer.append("  <servlet-name>default</servlet-name>\n");
        stringBuffer.append("  <url-pattern>*.xlsx</url-pattern>\n");
        stringBuffer.append(" </servlet-mapping>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <servlet-mapping>\n");
        stringBuffer.append("  <servlet-name>default</servlet-name>\n");
        stringBuffer.append("  <url-pattern>*.otf</url-pattern>\n");
        stringBuffer.append(" </servlet-mapping>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <error-page>\n");
        stringBuffer.append("  <exception-type>java.lang.Throwable</exception-type>\n");
        stringBuffer.append("  <location>/500.jsp</location>\n");
        stringBuffer.append(" </error-page>\n");
        stringBuffer.append(" <error-page>\n");
        stringBuffer.append("  <error-code>500</error-code>\n");
        stringBuffer.append("  <location>/500.jsp</location>\n");
        stringBuffer.append(" </error-page>\n");
        stringBuffer.append(" <error-page>\n");
        stringBuffer.append("  <error-code>404</error-code>\n");
        stringBuffer.append("  <location>/404.jsp</location>\n");
        stringBuffer.append(" </error-page>\n");
        stringBuffer.append(" <error-page>\n");
        stringBuffer.append("  <error-code>403</error-code>\n");
        stringBuffer.append("  <location>/500.jsp</location>\n");
        stringBuffer.append(" </error-page>\n");
        stringBuffer.append("</web-app>\n");
        return stringBuffer.toString();
    }
}
