package constant.tools.project.xml;

public class Servletxml {

    public static String generate() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        stringBuffer.append(
                "<beans xmlns=\"http://www.springframework.org/schema/beans\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");
        stringBuffer.append(
                " xmlns:tx=\"http://www.springframework.org/schema/tx\" xmlns:context=\"http://www.springframework.org/schema/context\"\n");
        stringBuffer.append(
                " xmlns:aop=\"http://www.springframework.org/schema/aop\" xmlns:mvc=\"http://www.springframework.org/schema/mvc\" xmlns:util=\"http://www.springframework.org/schema/util\"\n");
        stringBuffer.append(" xsi:schemaLocation=\"http://www.springframework.org/schema/beans \n");
        stringBuffer.append(" http://www.springframework.org/schema/beans/spring-beans-4.2.xsd \n");
        stringBuffer.append(" http://www.springframework.org/schema/tx\n");
        stringBuffer.append(" http://www.springframework.org/schema/tx/spring-tx-4.1.xsd\n");
        stringBuffer.append(" http://www.springframework.org/schema/context\n");
        stringBuffer.append(" http://www.springframework.org/schema/context/spring-context-4.2.xsd\n");
        stringBuffer.append(" http://www.springframework.org/schema/aop\n");
        stringBuffer.append(" http://www.springframework.org/schema/aop/spring-aop-4.2.xsd\n");
        stringBuffer.append(" http://www.springframework.org/schema/mvc\n");
        stringBuffer.append(" http://www.springframework.org/schema/mvc/spring-mvc-4.2.xsd\n");
        stringBuffer.append(
                " http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util-4.2.xsd\">\n");
        stringBuffer.append("\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <bean class=\"org.springframework.web.servlet.view.InternalResourceViewResolver\">\n");
        stringBuffer
                .append("  <property name=\"viewClass\" value=\"org.springframework.web.servlet.view.JstlView\" />\n");
        stringBuffer.append("  <property name=\"prefix\" value=\"/WEB-INF/jsp/\" />\n");
        stringBuffer.append("  <property name=\"suffix\" value=\".jsp\" />\n");
        stringBuffer.append(" </bean>\n");
        stringBuffer.append("\n");
        stringBuffer.append(
                " <bean id=\"multipartResolver\" class=\"org.springframework.web.multipart.commons.CommonsMultipartResolver\">\n");
        stringBuffer.append("  <property name=\"defaultEncoding\" value=\"UTF-8\" />\n");
        stringBuffer.append("  <property name=\"maxUploadSize\" value=\"8192000\" />\n");
        stringBuffer.append(" </bean>\n");
        stringBuffer.append("\n");
        stringBuffer.append(
                " <bean id=\"exceptionResolver\" class=\"org.springframework.web.servlet.handler.SimpleMappingExceptionResolver\">\n");
        stringBuffer.append("  <property name=\"exceptionMappings\">\n");
        stringBuffer.append("   <props>\n");
        stringBuffer.append(
                "    <prop key=\"org.springframework.web.multipart.MaxUploadSizeExceededException\">error_fileupload</prop>\n");
        stringBuffer.append("   </props>\n");
        stringBuffer.append("  </property>\n");
        stringBuffer.append(" </bean>\n");
        stringBuffer.append("\n");
        stringBuffer.append(
                " <bean id=\"mappingJacksonHttpMessageConverter\" class=\"org.springframework.http.converter.json.MappingJackson2HttpMessageConverter\">\n");
        stringBuffer.append("  <property name=\"supportedMediaTypes\">\n");
        stringBuffer.append("   <list>\n");
        stringBuffer.append("    <value>application/json;charset=utf-8</value>\n");
        stringBuffer.append("   </list>\n");
        stringBuffer.append("  </property>\n");
        stringBuffer.append(" </bean>\n");
        stringBuffer.append("\n");
        stringBuffer.append(
                " <bean class=\"org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter\">\n");
        stringBuffer.append("  <property name=\"messageConverters\">\n");
        stringBuffer.append("   <util:list id=\"beanList\">\n");
        stringBuffer.append("    <ref bean=\"mappingJacksonHttpMessageConverter\" />\n");
        stringBuffer.append("   </util:list>\n");
        stringBuffer.append("  </property>\n");
        stringBuffer.append(" </bean>\n");
        stringBuffer.append("\n");
        stringBuffer.append("</beans>\n");
        return stringBuffer.toString();
    }
}
