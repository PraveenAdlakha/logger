package com.mylogger.logger.impl;

import java.io.*;
import java.util.Properties;

public class PropertiesReader {

    private static Properties properties;
    private PropertiesReader(){
        init();
    }

    private static void init(){
        properties = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("src/main/resources/log4j.properties");
            System.out.println("Working dir:"+System.getProperty("user.dir"));
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("File not found: ");
        } finally {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    }

    public static Properties getPropertiesReader() {
        if(properties == null){
            properties = new Properties();
            init();
        }
        return properties;
    }


}
