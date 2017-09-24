package com.mylogger.logger.sinks;

import com.mylogger.logger.impl.PropertiesReader;

import java.util.Properties;

public class Test {

    public static void main(String[] args) {

        for(int i=1;i<23;i++){
            System.out.println("sudo -u yoda sh daily-register.sh " +
                    "richmedia_raw pl yyyy-MM-dd-HH hourly 2017-09-23-"+ i + " 2017-09-23-"+i+"");
        }
//        Properties properties = PropertiesReader.getPropertiesReader();
//        FileSink fileSink = FileSink.getSink();
//        int i=0;
//        while (++i != 5)
//        fileSink.writeData("This is test");
    }
}
