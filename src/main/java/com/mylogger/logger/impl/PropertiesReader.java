package com.mylogger.logger.impl;

import java.io.*;
import java.util.Properties;

import static com.mylogger.logger.Constants.FILELOCATION;

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
            properties.load(input);
            System.out.println("Check Log file "+ properties.getProperty(FILELOCATION));
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

    public static Properties    getPropertiesReader() {
        if(properties == null){
            properties = new Properties();
            init();
        }
        return properties;
    }


}
