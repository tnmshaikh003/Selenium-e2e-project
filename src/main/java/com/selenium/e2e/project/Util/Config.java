package com.selenium.e2e.project.Util;

import java.util.List;

public class Config {

    private String defaultEnviroment;
    private String defaultBrowser;
    private List<Environment> environment;

    public String getDefaultEnviroment() {
        return defaultEnviroment;
    }

    public List<Environment> getEnvironment() {
        return environment;
    }

      public String getDefaultBrowser() {
        return defaultBrowser;
    }

    public void setDefaultBrowser(String defaultBrowser) {
        this.defaultBrowser = defaultBrowser;
    }

    public void setDefaultEnviroment(String defaultEnviroment) {
        this.defaultEnviroment = defaultEnviroment;
    }

    public void setEnvironment(List<Environment> environment) {
        this.environment = environment;
    }

}
