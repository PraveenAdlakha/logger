package com.mylogger.logger.impl;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import com.mylogger.logger.ILogger;
import com.mylogger.logger.Sink;
import com.mylogger.logger.LoggingLevel;
import com.mylogger.logger.sinks.FileSink;

import static com.mylogger.logger.Constants.*;

public final class LoggerFactory {
  //1.TODO parse the xml file and instatiate the map for Logging LEVEL and p
  //pass that map to the simpleLoggerSync instance and rest of them
  //TODO 2. create the object map of every class which calls this class.

  private static int IsInitialized;
  private static boolean isAsync;
  private static String logFilePath;
  private static Properties properties;
  public static final String file_location = new String("file_location");

  private static Map<String, ILogger> classLoggerObjectMap;
  private static Map<LoggingLevel, Sink> levelSinkMap;


  private static void init(){
    properties = PropertiesReader.getPropertiesReader();
    classLoggerObjectMap = new ConcurrentHashMap<String, ILogger>();
    levelSinkMap = new ConcurrentHashMap<LoggingLevel, Sink>();
    logFilePath = new String(properties.getProperty(file_location));
    //TODO remove this and fill it through properties file
    if (properties.getProperty(INFOSINKTYPE).equals(FILE)){
      levelSinkMap.put(LoggingLevel.INFO, FileSink.getSink());
    }
    if (properties.getProperty(ERRORSINKTYPE).equals(FILE)){
      levelSinkMap.put(LoggingLevel.ERROR, FileSink.getSink());
    }
    if (properties.getProperty(DEBUGSINKTYPE).equals(FILE)){
      levelSinkMap.putIfAbsent(LoggingLevel.DEBUG, FileSink.getSink());
    }
    if(properties.getProperty(WRITEMODE) == ASYNC){
      isAsync = true;
    } else {
      isAsync = false;
    }

  }

  public static ILogger getLogger(String name) {
    if(null == classLoggerObjectMap || null == levelSinkMap ){
      init();
    }
    if (null != classLoggerObjectMap.get(name)) {
      return classLoggerObjectMap.get(name);
    } else {
      if (isAsync) {
        return classLoggerObjectMap.computeIfAbsent(name,
            n -> new SimpleAsyncLogger(levelSinkMap, name));
      }
      return classLoggerObjectMap.computeIfAbsent(name, n -> new SimpleSyncLogger(levelSinkMap, name));
    }
  }
}
