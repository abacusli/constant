package constant.tools.project.xml;

public class Autoconfxml {

    public static String generate(String name) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        stringBuffer.append("<config>\n");
        stringBuffer.append(" <group>\n");
        stringBuffer
                .append("  <property name=\"" + name + "\" defaultValue=\"" + name + "\" description=\"应用程序名称\" />\n");
        stringBuffer.append(
                "  <property name=\"" + name + ".work\" defaultValue=\"${user.home}\" description=\"应用程序的工作目录\" />\n");
        stringBuffer.append("  <property name=\"" + name + ".loggingRoot\" defaultValue=\"${" + name + ".work}/logs/${"
                + name + "}\"\n");
        stringBuffer.append("   description=\"日志文件目录\" />\n");
        stringBuffer.append("  <property name=\"" + name + ".upload\" defaultValue=\"${" + name + ".work}/upload/${"
                + name + "}\"\n");
        stringBuffer.append("   description=\"上传文件的目录\" />\n");
        stringBuffer.append(
                "  <property name=\"" + name + ".loggingLevel\" defaultValue=\"info\" description=\"日志文件级别\">\n");
        stringBuffer.append("   <validator name=\"choice\" choice=\"trace, debug, info, warn, error\" />\n");
        stringBuffer.append("  </property>\n");
        stringBuffer.append(" </group>\n");
        stringBuffer.append("\n");
        stringBuffer.append(" <script>\n");
        stringBuffer.append("  <generate template=\"META-INF/autoconf/" + name
                + ".logback.xml\" destfile=\"WEB-INF/classes/" + name + ".logback.xml\" />\n");
        stringBuffer.append(" </script>\n");
        stringBuffer.append("</config>\n");
        return stringBuffer.toString();
    }
}
