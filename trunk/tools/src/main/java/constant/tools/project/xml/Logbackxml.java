package constant.tools.project.xml;

public class Logbackxml {

    public static String generate(String name) {
        StringBuffer stringBuffer = new StringBuffer();
        String n = name.replace('.', '_');

        stringBuffer.append(" <?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        stringBuffer.append("<configuration>\n");
        stringBuffer.append(" <!--定义日志文件的存储地址 勿在 LogBack 的配置中使用相对路径 -->\n");
        stringBuffer.append(" <!-- 控制台输出 -->\n");
        stringBuffer.append(" <appender name=\"STDOUT\" class=\"ch.qos.logback.core.ConsoleAppender\">\n");
        stringBuffer.append("  <!-- 日志输出编码 -->\n");
        stringBuffer.append("  <encoding>UTF-8</encoding>\n");
        stringBuffer.append("  <layout class=\"ch.qos.logback.classic.PatternLayout\">\n");
        stringBuffer.append("   <!-- 格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符 -->\n");
        stringBuffer
                .append("   <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} %M [%line]- %msg%n\n");
        stringBuffer.append("   </pattern>\n");
        stringBuffer.append("  </layout>\n");
        stringBuffer.append(" </appender>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <!-- 按照每天生成日志文件 -->\n");
        stringBuffer.append(
                " <appender name=\"DAO_DEBUG_FILE\" class=\"ch.qos.logback.core.rolling.RollingFileAppender\">\n");
        stringBuffer.append("  <encoding>UTF-8</encoding>\n");
        stringBuffer.append("  <file>${" + n + "_loggingRoot}/dao.debug.log</file>\n");
        stringBuffer.append("  <filter class=\"ch.qos.logback.classic.filter.LevelFilter\">\n");
        stringBuffer.append("   <level>DEBUG</level>\n");
        stringBuffer.append("   <onMatch>ACCEPT</onMatch>\n");
        stringBuffer.append("   <onMismatch>DENY</onMismatch>\n");
        stringBuffer.append("  </filter>\n");
        stringBuffer.append("  <rollingPolicy class=\"ch.qos.logback.core.rolling.TimeBasedRollingPolicy\">\n");
        stringBuffer.append("   <fileNamePattern>${" + n + "_loggingRoot}/dao.debug.log.%d{yyyy-MM-dd}-%i.zip\n");
        stringBuffer.append("   </fileNamePattern>\n");
        stringBuffer.append("   <maxHistory>30</maxHistory>\n");
        stringBuffer.append(
                "   <timeBasedFileNamingAndTriggeringPolicy class=\"ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP\">\n");
        stringBuffer.append("    <maxFileSize>60MB</maxFileSize>\n");
        stringBuffer.append("   </timeBasedFileNamingAndTriggeringPolicy>\n");
        stringBuffer.append("  </rollingPolicy>\n");
        stringBuffer.append("  <layout class=\"ch.qos.logback.classic.PatternLayout\">\n");
        stringBuffer.append("   <!-- 格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符 -->\n");
        stringBuffer
                .append("   <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} %M [%line]- %msg%n\n");
        stringBuffer.append("   </pattern>\n");
        stringBuffer.append("  </layout>\n");
        stringBuffer.append(" </appender>\n");
        stringBuffer.append("\n");
        stringBuffer
                .append(" <appender name=\"DEBUG_FILE\" class=\"ch.qos.logback.core.rolling.RollingFileAppender\">\n");
        stringBuffer.append("  <encoding>UTF-8</encoding>\n");
        stringBuffer.append("  <file>${" + n + "_loggingRoot}/debug.log</file>\n");
        stringBuffer.append("  <filter class=\"ch.qos.logback.classic.filter.LevelFilter\">\n");
        stringBuffer.append("   <level>DEBUG</level>\n");
        stringBuffer.append("   <onMatch>ACCEPT</onMatch>\n");
        stringBuffer.append("   <onMismatch>DENY</onMismatch>\n");
        stringBuffer.append("  </filter>\n");
        stringBuffer.append("  <rollingPolicy class=\"ch.qos.logback.core.rolling.TimeBasedRollingPolicy\">\n");
        stringBuffer.append("   <fileNamePattern>${" + n + "_loggingRoot}/debug.log.%d{yyyy-MM-dd}-%i.zip\n");
        stringBuffer.append("   </fileNamePattern>\n");
        stringBuffer.append("   <maxHistory>30</maxHistory>\n");
        stringBuffer.append(
                "   <timeBasedFileNamingAndTriggeringPolicy class=\"ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP\">\n");
        stringBuffer.append("    <maxFileSize>60MB</maxFileSize>\n");
        stringBuffer.append("   </timeBasedFileNamingAndTriggeringPolicy>\n");
        stringBuffer.append("  </rollingPolicy>\n");
        stringBuffer.append("  <layout class=\"ch.qos.logback.classic.PatternLayout\">\n");
        stringBuffer.append("   <!-- 格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符 -->\n");
        stringBuffer
                .append("   <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} %M [%line]- %msg%n\n");
        stringBuffer.append("   </pattern>\n");
        stringBuffer.append("  </layout>\n");
        stringBuffer.append(" </appender>\n");
        stringBuffer.append("\n");
        stringBuffer
                .append(" <appender name=\"INFO_FILE\" class=\"ch.qos.logback.core.rolling.RollingFileAppender\">\n");
        stringBuffer.append("  <encoding>UTF-8</encoding>\n");
        stringBuffer.append("  <file>${" + n + "_loggingRoot}/info.log</file>\n");
        stringBuffer.append("  <filter class=\"ch.qos.logback.classic.filter.LevelFilter\">\n");
        stringBuffer.append("   <level>INFO</level>\n");
        stringBuffer.append("   <onMatch>ACCEPT</onMatch>\n");
        stringBuffer.append("   <onMismatch>DENY</onMismatch>\n");
        stringBuffer.append("  </filter>\n");
        stringBuffer.append("  <rollingPolicy class=\"ch.qos.logback.core.rolling.TimeBasedRollingPolicy\">\n");
        stringBuffer.append("   <fileNamePattern>${" + n + "_loggingRoot}/info.log.%d{yyyy-MM-dd}-%i.zip\n");
        stringBuffer.append("   </fileNamePattern>\n");
        stringBuffer.append("   <maxHistory>30</maxHistory>\n");
        stringBuffer.append(
                "   <timeBasedFileNamingAndTriggeringPolicy class=\"ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP\">\n");
        stringBuffer.append("    <maxFileSize>40MB</maxFileSize>\n");
        stringBuffer.append("   </timeBasedFileNamingAndTriggeringPolicy>\n");
        stringBuffer.append("  </rollingPolicy>\n");
        stringBuffer.append("  <layout class=\"ch.qos.logback.classic.PatternLayout\">\n");
        stringBuffer.append("   <!-- 格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符 -->\n");
        stringBuffer
                .append("   <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} %M [%line]- %msg%n\n");
        stringBuffer.append("   </pattern>\n");
        stringBuffer.append("  </layout>\n");
        stringBuffer.append(" </appender>\n");
        stringBuffer.append("\n");
        stringBuffer
                .append(" <appender name=\"WARN_FILE\" class=\"ch.qos.logback.core.rolling.RollingFileAppender\">\n");
        stringBuffer.append("  <encoding>UTF-8</encoding>\n");
        stringBuffer.append("  <file>${" + n + "_loggingRoot}/warn.log</file>\n");
        stringBuffer.append("  <filter class=\"ch.qos.logback.classic.filter.LevelFilter\">\n");
        stringBuffer.append("   <level>WARN</level>\n");
        stringBuffer.append("   <onMatch>ACCEPT</onMatch>\n");
        stringBuffer.append("   <onMismatch>DENY</onMismatch>\n");
        stringBuffer.append("  </filter>\n");
        stringBuffer.append("  <rollingPolicy class=\"ch.qos.logback.core.rolling.TimeBasedRollingPolicy\">\n");
        stringBuffer.append("   <fileNamePattern>${" + n + "_loggingRoot}/warn.log.%d{yyyy-MM-dd}-%i.zip\n");
        stringBuffer.append("   </fileNamePattern>\n");
        stringBuffer.append("   <maxHistory>30</maxHistory>\n");
        stringBuffer.append(
                "   <timeBasedFileNamingAndTriggeringPolicy class=\"ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP\">\n");
        stringBuffer.append("    <maxFileSize>30MB</maxFileSize>\n");
        stringBuffer.append("   </timeBasedFileNamingAndTriggeringPolicy>\n");
        stringBuffer.append("  </rollingPolicy>\n");
        stringBuffer.append("  <layout class=\"ch.qos.logback.classic.PatternLayout\">\n");
        stringBuffer.append("   <!-- 格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符 -->\n");
        stringBuffer
                .append("   <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} %M [%line]- %msg%n\n");
        stringBuffer.append("   </pattern>\n");
        stringBuffer.append("  </layout>\n");
        stringBuffer.append(" </appender>\n");
        stringBuffer.append("\n");
        stringBuffer
                .append(" <appender name=\"ERROR_FILE\" class=\"ch.qos.logback.core.rolling.RollingFileAppender\">\n");
        stringBuffer.append("  <encoding>UTF-8</encoding>\n");
        stringBuffer.append("  <file>${" + n + "_loggingRoot}/error.log</file>\n");
        stringBuffer.append("  <filter class=\"ch.qos.logback.classic.filter.LevelFilter\">\n");
        stringBuffer.append("   <level>ERROR</level>\n");
        stringBuffer.append("   <onMatch>ACCEPT</onMatch>\n");
        stringBuffer.append("   <onMismatch>DENY</onMismatch>\n");
        stringBuffer.append("  </filter>\n");
        stringBuffer.append("  <rollingPolicy class=\"ch.qos.logback.core.rolling.TimeBasedRollingPolicy\">\n");
        stringBuffer.append("   <fileNamePattern>${" + n + "_loggingRoot}/error.log.%d{yyyy-MM-dd}-%i.zip\n");
        stringBuffer.append("   </fileNamePattern>\n");
        stringBuffer.append("   <maxHistory>30</maxHistory>\n");
        stringBuffer.append(
                "   <timeBasedFileNamingAndTriggeringPolicy class=\"ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP\">\n");
        stringBuffer.append("    <maxFileSize>20MB</maxFileSize>\n");
        stringBuffer.append("   </timeBasedFileNamingAndTriggeringPolicy>\n");
        stringBuffer.append("  </rollingPolicy>\n");
        stringBuffer.append("  <layout class=\"ch.qos.logback.classic.PatternLayout\">\n");
        stringBuffer.append("   <!-- 格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符 -->\n");
        stringBuffer
                .append("   <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} %M [%line]- %msg%n\n");
        stringBuffer.append("   </pattern>\n");
        stringBuffer.append("  </layout>\n");
        stringBuffer.append("  <!-- <Encoding></Encoding>\n");
        stringBuffer.append("   <Encoding>UTF-8</Encoding>\n");
        stringBuffer.append("   <rollingPolicy class=\"ch.qos.logback.core.rolling.TimeBasedRollingPolicy\">\n");
        stringBuffer.append("   日志文件输出的文件名\n");
        stringBuffer.append(
                "   <FileNamePattern>${" + n + "_loggingRoot}/error.log.%d{yyyy-MM-dd}.log</FileNamePattern>\n");
        stringBuffer.append("   <MaxHistory>30</MaxHistory>\n");
        stringBuffer.append("   </rollingPolicy>\n");
        stringBuffer.append("   <layout class=\"ch.qos.logback.classic.PatternLayout\">\n");
        stringBuffer.append("   格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符\n");
        stringBuffer
                .append("   <Pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} %M [%line]- %msg%n\n");
        stringBuffer.append("   </Pattern>\n");
        stringBuffer.append("   </layout>\n");
        stringBuffer.append("   日志文件最大的大小\n");
        stringBuffer.append("   <triggeringPolicy class=\"ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy\">\n");
        stringBuffer.append("   <MaxFileSize>10MB</MaxFileSize>\n");
        stringBuffer.append("   </triggeringPolicy> -->\n");
        stringBuffer.append(" </appender>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <logger name=\"dao\" level=\"DEBUG\" additivity=\"false\">\n");
        stringBuffer.append("  <!-- <appender-ref ref=\"STDOUT\" /> -->\n");
        stringBuffer.append("  <appender-ref ref=\"ERROR_FILE\" />\n");
        stringBuffer.append("  <appender-ref ref=\"WARN_FILE\" />\n");
        stringBuffer.append("  <appender-ref ref=\"INFO_FILE\" />\n");
        stringBuffer.append("  <appender-ref ref=\"DAO_DEBUG_FILE\" />\n");
        stringBuffer.append(" </logger>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <!-- 日志输出级别 -->\n");
        stringBuffer.append(" <root level=\"${" + n + "_loggingLevel}\">\n");
        stringBuffer.append("  <!-- <appender-ref ref=\"STDOUT\" /> -->\n");
        stringBuffer.append("  <appender-ref ref=\"ERROR_FILE\" />\n");
        stringBuffer.append("  <appender-ref ref=\"WARN_FILE\" />\n");
        stringBuffer.append("  <appender-ref ref=\"INFO_FILE\" />\n");
        stringBuffer.append("  <appender-ref ref=\"DEBUG_FILE\" />\n");
        stringBuffer.append(" </root>\n");
        stringBuffer.append("</configuration>\n");
        return stringBuffer.toString();
    }
}
