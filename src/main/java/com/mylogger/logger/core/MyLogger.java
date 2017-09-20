package com.mylogger.logger.core;

import com.mylogger.logger.sinks.FileSink;
import com.mylogger.logger.sinks.Sink;

import java.util.Map;

public class MyLogger {
    private Map<LoggingLevel, Sink> levelSinkMap;

    public MyLogger(){
        //TODO read the xml and make the map meaningful
        levelSinkMap.put(LoggingLevel.INFO, FileSink.getFileSink());
    }

    public void debug(String s){};
    public void info(String s){};
    public void error(String s){};
}
