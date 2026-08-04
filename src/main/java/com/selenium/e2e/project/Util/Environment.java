package com.selenium.e2e.project.Util;

public class Environment {
    private String name;
    private String baseUrl;
    private String testDataPath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setTestDataPath(String testDataPath) {
        this.testDataPath = testDataPath;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getTestDataPath() {
        return testDataPath;
    }

}
