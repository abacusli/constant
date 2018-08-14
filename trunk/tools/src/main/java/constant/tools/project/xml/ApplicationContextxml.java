package constant.tools.project.xml;

public class ApplicationContextxml {

    public static String generate(String name) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        stringBuffer.append(
                "<beans xmlns=\"http://www.springframework.org/schema/beans\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");
        stringBuffer.append(
                " xmlns:tx=\"http://www.springframework.org/schema/tx\" xmlns:context=\"http://www.springframework.org/schema/context\"\n");
        stringBuffer.append(" xmlns:aop=\"http://www.springframework.org/schema/aop\"\n");
        stringBuffer.append(" xsi:schemaLocation=\"http://www.springframework.org/schema/beans\n");
        stringBuffer.append(" http://www.springframework.org/schema/beans/spring-beans-4.2.xsd\n");
        stringBuffer.append(" http://www.springframework.org/schema/tx\n");
        stringBuffer.append(" http://www.springframework.org/schema/tx/spring-tx-4.1.xsd\n");
        stringBuffer.append(" http://www.springframework.org/schema/context\n");
        stringBuffer.append(" http://www.springframework.org/schema/context/spring-context-4.2.xsd\n");
        stringBuffer.append(" http://www.springframework.org/schema/aop\n");
        stringBuffer.append(" http://www.springframework.org/schema/aop/spring-aop-4.2.xsd\">\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <import resource=\"classpath:applicationContext.xml\" />\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <!-- 事务管理器 -->\n");
        stringBuffer.append(
                " <bean id=\"transactionManager\" class=\"org.springframework.jdbc.datasource.DataSourceTransactionManager\">\n");
        stringBuffer.append("  <property name=\"dataSource\" ref=\"dataSource\" />\n");
        stringBuffer.append(" </bean>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <!-- 事务注解驱动，标注@Transactional的类和方法将具有事务性 -->\n");
        stringBuffer.append(" <tx:annotation-driven />\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <context:component-scan base-package=\"" + name + ".common.*\" />\n");
        stringBuffer.append("\n");
        stringBuffer.append("</beans>\n");
        return stringBuffer.toString();
    }
}
