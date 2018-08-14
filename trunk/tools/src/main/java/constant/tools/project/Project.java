package constant.tools.project;

import java.util.ArrayList;
import java.util.List;

public class Project {

    public static final int     WAR         = 1;

    public static final int     JAR         = 2;

    public static final int     POM         = 3;

    private final List<Project> subProjects = new ArrayList<Project>();

    private final int           projectType;

    private String              projectName;

    public Project(String projectName, int projectType) {
        super();
        this.projectName = projectName;
        this.projectType = projectType;
    }

    public List<Project> getSubProjects() {
        return subProjects;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectType() {
        return projectType;
    }

    public String projectTypeToString() {
        if (WAR == projectType) {
            return "war";
        }
        if (JAR == projectType) {
            return "jar";
        }
        if (POM == projectType) {
            return "pom";
        }
        return "pom";
    }

}
