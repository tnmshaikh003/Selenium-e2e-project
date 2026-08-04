package com.selenium.e2e.project.Util;

import java.util.List;

public class Config {

    private String defaultEnviroment;
    private List<Environment> environment;

    public String getDefaultEnviroment() {
        return defaultEnviroment;
    }

    public List<Environment> getEnvironment() {
        return environment;
    }

    public void setDefaultEnviroment(String defaultEnviroment) {
        this.defaultEnviroment = defaultEnviroment;
    }

    public void setEnvironment(List<Environment> environment) {
        this.environment = environment;
    }

}
