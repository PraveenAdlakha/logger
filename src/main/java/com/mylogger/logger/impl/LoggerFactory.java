package com.mylogger.logger.impl;

import com.mylogger.logger.core.LoggingLevel;
import com.mylogger.logger.core.MyLogger;
import com.mylogger.logger.sinks.FileSink;
import com.mylogger.logger.sinks.Sink;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class LoggerFactory {
    //1.TODO parse the xml file and instatiate the map for Logging LEVEL and p
    //pass that map to the simpleLoggerSync instance and rest of them
    //TODO 2. create the object map of every class which calls this class.

    private static int IsInitialized;
    private static boolean isAsync;

    private static Map<String, MyLogger> classLoggerObjectMap;
    private static Map<LoggingLevel, Sink> levelSinkMap;

    //TODO find a better way to do it.
    static {
        classLoggerObjectMap = new ConcurrentHashMap<String, MyLogger>();
        levelSinkMap = new ConcurrentHashMap<LoggingLevel, Sink>();
        //TODO remove this and fill it through sml parser
        levelSinkMap.put(LoggingLevel.INFO, FileSink.getFileSink());
        isAsync = true;
    }

    public static void LoggerFactory(){
        classLoggerObjectMap = new ConcurrentHashMap<String, MyLogger>();
        levelSinkMap = new ConcurrentHashMap<LoggingLevel, Sink>();
        //TODO remove this and fill it through sml parser
        levelSinkMap.put(LoggingLevel.INFO, FileSink.getFileSink());
        isAsync = true;
    }

    public static MyLogger getLogger(String name){
        MyLogger logger;
        if(null != classLoggerObjectMap.get(name)){
            return classLoggerObjectMap.get(name);
        }
        else {
            if(isAsync){
             logger = new SimpleLoggerSync(name, levelSinkMap);
                classLoggerObjectMap.putIfAbsent(name, logger);
             return logger;
            }
            else
            {    //TODO return asyncLogger Object
                logger = new SimpleLoggerSync(name, levelSinkMap);
                classLoggerObjectMap.putIfAbsent(name, logger);

                return logger;
            }
        }
    }

}
