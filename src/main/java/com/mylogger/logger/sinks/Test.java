package com.mylogger.logger.sinks;

import com.mylogger.logger.impl.PropertiesReader;

import java.util.Properties;

public class Test {

    public static void main(String[] args) {
        Properties properties = PropertiesReader.getPropertiesReader();
        FileSink fileSink = FileSink.getFileSink(properties.getProperty("file_location"));
        int i=0;
        while (++i != 5)
        fileSink.writeData("This is test");
    }
}
