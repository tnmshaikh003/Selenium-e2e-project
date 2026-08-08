package com.selenium.e2e.project.Util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;

public class ParseJson{

    public static  String getEnvironment(){

        try {
            ObjectMapper mapper = new ObjectMapper();
            Config config = mapper.readValue(new File("Config/config.json"), Config.class);
            return config.getDefaultEnviroment();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static  String getTestDataPath(String env){

        try {
            ObjectMapper mapper = new ObjectMapper();
            Config config = mapper.readValue(new File("Config/config.json"), Config.class);
           List<Environment> list = config.getEnvironment();
           for(Environment ev:list){
                if(ev.getName().equalsIgnoreCase(env)){
                    return ev.getTestDataPath();
                }
                
           }
        } catch (Exception e) {
            throw new RuntimeException(e);
        
        }
        return null;
    }

      public static  String getBaseUrl(String env){

        try {
            ObjectMapper mapper = new ObjectMapper();
            Config config = mapper.readValue(new File("Config/config.json"), Config.class);
           List<Environment> list = config.getEnvironment();
           for(Environment ev:list){
                if(ev.getName().equalsIgnoreCase(env)){
                    return ev.getBaseUrl();
                }
                
           }
        } catch (Exception e) {
            throw new RuntimeException(e);
        
        }
        return null;
    }

     public static  String getDefaultBrowser(){

        try {
            ObjectMapper mapper = new ObjectMapper();
            Config config = mapper.readValue(new File("Config/config.json"), Config.class);
            return config.getDefaultBrowser();
         
        } catch (Exception e) {
            throw new RuntimeException(e);
        
        }
      
    }

      public static  boolean isHeadless(){

        try {
            ObjectMapper mapper = new ObjectMapper();
            Config config = mapper.readValue(new File("Config/config.json"), Config.class);
            return config.isHeadless();
         
        } catch (Exception e) {
            System.out.println("problem in isHeadless method");
            throw new RuntimeException(e);
        
        }
      
    }

}
