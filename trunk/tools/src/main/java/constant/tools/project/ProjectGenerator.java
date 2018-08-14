package constant.tools.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import constant.tools.project.xml.ApplicationContextxml;
import constant.tools.project.xml.Autoconfxml;
import constant.tools.project.xml.LogbackInResourcesxml;
import constant.tools.project.xml.Logbackxml;
import constant.tools.project.xml.Servletxml;
import constant.tools.project.xml.Webxml;

public class ProjectGenerator {

    public static void main(String[] args) {
        Project project = new Project("com.abacusli", Project.POM);
        project.getSubProjects().add(new Project("core", Project.JAR));
        project.getSubProjects().add(new Project("utils", Project.JAR));
        project.getSubProjects().add(new Project("client", Project.JAR));
        project.getSubProjects().add(new Project("shared", Project.JAR));
        project.getSubProjects().add(new Project("domain", Project.JAR));
        project.getSubProjects().add(new Project("mapper", Project.JAR));
        project.getSubProjects().add(new Project("service", Project.JAR));
        project.getSubProjects().add(new Project("docs", Project.WAR));
        project.getSubProjects().add(new Project("open", Project.WAR));
        project.getSubProjects().add(new Project("admin", Project.WAR));
        project.getSubProjects().add(new Project("agent", Project.WAR));
        project.getSubProjects().add(new Project("boss", Project.WAR));
        generate(project);
    }

    private static void generate(Project project) {
        new File("./" + project.getProjectName() + "/all").mkdirs();
        new File("./" + project.getProjectName() + "/managed").mkdirs();
        for (Project sub : project.getSubProjects()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(
                    "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");
            stringBuffer.append(
                    " xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n");
            stringBuffer.append(" <modelVersion>4.0.0</modelVersion>\n");

            if (sub.getProjectType() == Project.POM) {
                new File("./" + project.getProjectName() + "/" + sub.getProjectName()).mkdirs();
            } else if (sub.getProjectType() == Project.JAR) {
                new File("./" + project.getProjectName() + "/" + sub.getProjectName() + "/src/main/java").mkdirs();
                new File("./" + project.getProjectName() + "/" + sub.getProjectName() + "/src/test/java").mkdirs();
                new File("./" + project.getProjectName() + "/" + sub.getProjectName() + "/src/main/resources").mkdirs();
                new File("./" + project.getProjectName() + "/" + sub.getProjectName() + "/src/test/resources").mkdirs();
            } else if (sub.getProjectType() == Project.WAR) {
                new File("./" + project.getProjectName() + "/" + sub.getProjectName() + "/src/main/java").mkdirs();
                new File("./" + project.getProjectName() + "/" + sub.getProjectName() + "/src/test/java").mkdirs();
                new File("./" + project.getProjectName() + "/" + sub.getProjectName() + "/src/main/resources").mkdirs();
                new File("./" + project.getProjectName() + "/" + sub.getProjectName() + "/src/test/resources").mkdirs();

                new File("./" + project.getProjectName() + "/" + sub.getProjectName() + "/src/main/webapp/WEB-INF/lib")
                        .mkdirs();
                new File("./" + project.getProjectName() + "/" + sub.getProjectName() + "/src/main/webapp/WEB-INF/jsp")
                        .mkdirs();

                new File("./" + project.getProjectName() + "/" + sub.getProjectName()
                        + "/src/main/webapp/META-INF/autoconf").mkdirs();

                String name = project.getProjectName() + "." + sub.getProjectName();

                new File("./" + project.getProjectName() + "/" + sub.getProjectName() + "/src/main/java/"
                        + (name.replace('.', '/') + "/common")).mkdirs();

                String webxml = Webxml.generate(name);
                try {
                    IOUtils.write(webxml.toString(), new FileOutputStream("./" + project.getProjectName() + "/"
                            + sub.getProjectName() + "/src/main/webapp/WEB-INF/web.xml"));
                    IOUtils.write(Servletxml.generate(), new FileOutputStream("./" + project.getProjectName() + "/"
                            + sub.getProjectName() + "/src/main/webapp/WEB-INF/" + name + "-servlet.xml"));

                    IOUtils.write(Logbackxml.generate(name), new FileOutputStream("./" + project.getProjectName() + "/"
                            + sub.getProjectName() + "/src/main/webapp/META-INF/autoconf/" + name + ".logback.xml"));

                    IOUtils.write(Autoconfxml.generate(name), new FileOutputStream("./" + project.getProjectName() + "/"
                            + sub.getProjectName() + "/src/main/webapp/META-INF/autoconf/auto-config.xml"));

                    IOUtils.write(LogbackInResourcesxml.generate(name),
                            new FileOutputStream("./" + project.getProjectName() + "/" + sub.getProjectName()
                                    + "/src/main/resources/" + name + ".logback.xml"));

                    IOUtils.write(ApplicationContextxml.generate(name),
                            new FileOutputStream("./" + project.getProjectName() + "/" + sub.getProjectName()
                                    + "/src/main/resources/" + name + ".applicationContext.xml"));

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                continue;
            }

            stringBuffer.append(" <parent>\n");
            stringBuffer.append("  <groupId>" + project.getProjectName() + "</groupId>\n");
            stringBuffer.append("  <artifactId>" + project.getProjectName() + ".all</artifactId>\n");
            stringBuffer.append("  <relativePath>../all/pom.xml</relativePath>\n");
            stringBuffer.append("  <version>1.0-SNAPSHOT</version>\n");
            stringBuffer.append(" </parent>\n");

            stringBuffer.append("\n");

            stringBuffer.append(" <groupId>" + project.getProjectName() + "</groupId>\n");
            stringBuffer.append(
                    " <artifactId>" + project.getProjectName() + "." + sub.getProjectName() + "</artifactId>\n");
            stringBuffer.append(" <version>1.0-SNAPSHOT</version>\n");
            stringBuffer.append(" <packaging>" + sub.projectTypeToString() + "</packaging>\n");

            stringBuffer.append("\n");

            stringBuffer.append(" <name>" + project.getProjectName() + "." + sub.getProjectName() + "</name>\n");
            stringBuffer.append(" <url>http://maven.apache.org</url>\n");

            stringBuffer.append("\n");

            stringBuffer.append(" <dependencies>\n");

            stringBuffer.append("\n");

            stringBuffer.append("  <dependency>\n");
            stringBuffer.append("   <groupId>junit</groupId>\n");
            stringBuffer.append("   <artifactId>junit</artifactId>\n");
            //stringBuffer.append("   <version>4.12</version>\n");
            stringBuffer.append("   <scope>test</scope>\n");
            stringBuffer.append("  </dependency>\n");

            stringBuffer.append("\n");

            stringBuffer.append(" </dependencies>\n");

            stringBuffer.append("\n");

            stringBuffer.append(" <build>\n");
            stringBuffer.append("  <finalName>" + sub.getProjectName() + "</finalName>\n");

            stringBuffer.append("  <plugins>\n");
            stringBuffer.append("   <plugin>\n");
            stringBuffer.append("    <groupId>org.apache.maven.plugins</groupId>\n");
            stringBuffer.append("    <artifactId>maven-compiler-plugin</artifactId>\n");
            stringBuffer.append("   </plugin>\n");
            stringBuffer.append("   <plugin>\n");
            stringBuffer.append("    <groupId>com.alibaba.citrus.tool</groupId>\n");
            stringBuffer.append("    <artifactId>autoconfig-maven-plugin</artifactId>\n");
            stringBuffer.append("   </plugin>\n");
            stringBuffer.append("  </plugins>\n");

            stringBuffer.append(" </build>\n");
            stringBuffer.append("</project>\n");
            generatePomxml(project, sub, stringBuffer);
        }

        generateManagedPomxml(project);

        generateAllPomxml(project);

    }

    private static void generateAllPomxml(Project project) {
        Project sub = new Project("all", Project.POM);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(
                "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");
        stringBuffer.append(
                " xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n");
        stringBuffer.append(" <modelVersion>4.0.0</modelVersion>\n");

        stringBuffer.append("\n");

        stringBuffer.append(" <groupId>" + project.getProjectName() + "</groupId>\n");
        stringBuffer
                .append(" <artifactId>" + project.getProjectName() + "." + sub.getProjectName() + "</artifactId>\n");
        stringBuffer.append(" <version>1.0-SNAPSHOT</version>\n");
        stringBuffer.append(" <packaging>" + sub.projectTypeToString() + "</packaging>\n");

        stringBuffer.append("\n");

        stringBuffer.append(" <name>" + project.getProjectName() + "." + sub.getProjectName() + "</name>\n");
        stringBuffer.append(" <url>http://maven.apache.org</url>\n");

        stringBuffer.append("\n");

        stringBuffer.append(" <properties>\n");
        stringBuffer.append("  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\n");
        stringBuffer.append("  <maven.compiler.source>1.7</maven.compiler.source>\n");
        stringBuffer.append("  <maven.compiler.target>1.7</maven.compiler.target>\n");
        stringBuffer.append("  <maven.compiler.compilerVersion>1.7</maven.compiler.compilerVersion>\n");
        stringBuffer.append(" </properties>\n");

        stringBuffer.append("\n");

        stringBuffer.append(" <dependencyManagement>\n");

        stringBuffer.append("  <dependencies>\n");

        stringBuffer.append("\n");

        stringBuffer.append("   <dependency>\n");
        stringBuffer.append("    <groupId>junit</groupId>\n");
        stringBuffer.append("    <artifactId>junit</artifactId>\n");
        stringBuffer.append("    <version>4.12</version>\n");
        stringBuffer.append("    <scope>test</scope>\n");
        stringBuffer.append("   </dependency>\n");

        stringBuffer.append("\n");

        stringBuffer.append("  </dependencies>\n");
        stringBuffer.append(" </dependencyManagement>\n");
        stringBuffer.append("\n");

        stringBuffer.append(" <build>\n");
        stringBuffer.append("  <finalName>" + sub.getProjectName() + "</finalName>\n");

        stringBuffer.append("  <pluginManagement>\n");
        stringBuffer.append("   <plugins>\n");

        stringBuffer.append("    <plugin>\n");
        stringBuffer.append("     <groupId>org.apache.maven.plugins</groupId>\n");
        stringBuffer.append("     <artifactId>maven-compiler-plugin</artifactId>\n");
        stringBuffer.append("     <version>3.2</version>\n");
        stringBuffer.append("     <configuration>\n");
        stringBuffer.append("      <source>${maven.compiler.source}</source>\n");
        stringBuffer.append("      <target>${maven.compiler.target}</target>\n");
        stringBuffer.append("     </configuration>\n");
        stringBuffer.append("    </plugin>\n");

        stringBuffer.append("    <plugin>\n");
        stringBuffer.append("     <groupId>com.alibaba.citrus.tool</groupId>\n");
        stringBuffer.append("     <artifactId>autoconfig-maven-plugin</artifactId>\n");
        stringBuffer.append("     <version>1.2</version>\n");
        stringBuffer.append("     <configuration>\n");
        stringBuffer.append("     </configuration>\n");
        stringBuffer.append("     <executions>\n");
        stringBuffer.append("      <execution>\n");
        stringBuffer.append("       <phase>package</phase>\n");
        stringBuffer.append("       <goals>\n");
        stringBuffer.append("        <goal>autoconfig</goal>\n");
        stringBuffer.append("       </goals>\n");
        stringBuffer.append("      </execution>\n");
        stringBuffer.append("     </executions>\n");
        stringBuffer.append("    </plugin>\n");

        stringBuffer.append("   </plugins>\n");
        stringBuffer.append("  </pluginManagement>\n");

        stringBuffer.append(" </build>\n");
        stringBuffer.append("</project>\n");
        generatePomxml(project, sub, stringBuffer);

    }

    private static void generateManagedPomxml(Project project) {
        Project sub = new Project("managed", Project.POM);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(
                "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");
        stringBuffer.append(
                " xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n");
        stringBuffer.append(" <modelVersion>4.0.0</modelVersion>\n");

        stringBuffer.append("\n");

        stringBuffer.append(" <groupId>" + project.getProjectName() + "</groupId>\n");
        stringBuffer
                .append(" <artifactId>" + project.getProjectName() + "." + sub.getProjectName() + "</artifactId>\n");
        stringBuffer.append(" <version>1.0-SNAPSHOT</version>\n");
        stringBuffer.append(" <packaging>" + sub.projectTypeToString() + "</packaging>\n");

        stringBuffer.append("\n");

        stringBuffer.append(" <name>" + project.getProjectName() + "." + sub.getProjectName() + "</name>\n");
        stringBuffer.append(" <url>http://maven.apache.org</url>\n");

        stringBuffer.append("\n");

        stringBuffer.append(" <properties>\n");
        stringBuffer.append("  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\n");
        stringBuffer.append("  <maven.compiler.source>1.7</maven.compiler.source>\n");
        stringBuffer.append("  <maven.compiler.target>1.7</maven.compiler.target>\n");
        stringBuffer.append("  <maven.compiler.compilerVersion>1.7</maven.compiler.compilerVersion>\n");
        stringBuffer.append(" </properties>\n");

        stringBuffer.append("\n");

        stringBuffer.append(" <modules>\n");
        stringBuffer.append("  <module>../all</module>\n");
        for (Project c : project.getSubProjects()) {
            stringBuffer.append("  <module>../" + c.getProjectName() + "</module>\n");
        }
        stringBuffer.append(" </modules>\n");

        stringBuffer.append("\n");

        stringBuffer.append(" <build>\n");
        stringBuffer.append("  <finalName>" + sub.getProjectName() + "</finalName>\n");

        stringBuffer.append("  <plugins>\n");
        stringBuffer.append("   <plugin>\n");
        stringBuffer.append("    <groupId>org.apache.maven.plugins</groupId>\n");
        stringBuffer.append("    <artifactId>maven-compiler-plugin</artifactId>\n");
        stringBuffer.append("    <version>3.2</version>\n");
        stringBuffer.append("    <configuration>\n");
        stringBuffer.append("     <source>${maven.compiler.source}</source>\n");
        stringBuffer.append("     <target>${maven.compiler.target}</target>\n");
        stringBuffer.append("    </configuration>\n");
        stringBuffer.append("   </plugin>\n");
        stringBuffer.append("  </plugins>\n");

        stringBuffer.append(" </build>\n");
        stringBuffer.append("</project>\n");
        generatePomxml(project, sub, stringBuffer);

    }

    private static void generatePomxml(Project project, Project sub, StringBuffer stringBuffer) {
        try {
            IOUtils.write(stringBuffer.toString(),
                    new FileOutputStream("./" + project.getProjectName() + "/" + sub.getProjectName() + "/pom.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
