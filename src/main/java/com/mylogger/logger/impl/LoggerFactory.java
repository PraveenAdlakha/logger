package com.mylogger.logger.impl;

import com.mylogger.logger.core.MyLogger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class LoggerFactory {

    private static int IsInitialized;
    private static boolean isAsync;

    private static Map<String, MyLogger> objectMap ;

    public static void LoggerFactory(){
        objectMap = new ConcurrentHashMap<String, MyLogger>();
        isAsync = true;
    }

    public static MyLogger getLogger(String name){
        MyLogger logger = objectMap.get(name);
        if(logger != null){
            return logger;
        }
        else {
            if(isAsync){
             logger = new SimpleLoggerSync();
             return logger;
            }
            else
                return logger;
        }
    }

}
