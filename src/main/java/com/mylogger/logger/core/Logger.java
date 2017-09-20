package com.mylogger.logger.core;

import com.mylogger.logger.sinks.Sink;

import java.util.Map;

public abstract class Logger implements MyLogger {

    //TODO these map should be immutable
    public final Map<LoggingLevel, Sink> levelSinkMap;

    public Logger(Map<LoggingLevel, Sink> levelMyLoggerMap){
        this.levelSinkMap = levelMyLoggerMap;
    }
}
