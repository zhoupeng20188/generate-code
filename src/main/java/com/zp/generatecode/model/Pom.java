package com.zp.generatecode.model;

/**
 * @Author zp
 * @create 2021/2/20 16:26
 */
public class Pom {
    private String groupId;
    private String artifactId;
    private String projectName;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
