package com.mylogger.logger.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.mylogger.logger.ILogger;
import com.mylogger.logger.Sink;
import com.mylogger.logger.LoggingLevel;
import com.mylogger.logger.sinks.FileSink;

public final class LoggerFactory {
  //1.TODO parse the xml file and instatiate the map for Logging LEVEL and p
  //pass that map to the simpleLoggerSync instance and rest of them
  //TODO 2. create the object map of every class which calls this class.

  private static int IsInitialized;
  private static boolean isAsync;

  private static Map<String, ILogger> classLoggerObjectMap;
  private static Map<LoggingLevel, Sink> levelSinkMap;


  private static  void init(){
    classLoggerObjectMap = new ConcurrentHashMap<String, ILogger>();
    levelSinkMap = new ConcurrentHashMap<LoggingLevel, Sink>();
    //TODO remove this and fill it through sml parser
    levelSinkMap.put(LoggingLevel.INFO, FileSink.getFileSink());
    isAsync = true;
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
            n -> new SimpleAsyncLogger(levelSinkMap));
      }
      return classLoggerObjectMap.computeIfAbsent(name, n -> new SimpleSyncLogger(levelSinkMap));
    }
  }
}
