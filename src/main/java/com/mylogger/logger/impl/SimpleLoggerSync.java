package com.mylogger.logger.impl;

import com.mylogger.logger.core.Logger;
import com.mylogger.logger.core.LoggingLevel;
import com.mylogger.logger.core.MyLogger;
import com.mylogger.logger.sinks.FileSink;
import com.mylogger.logger.sinks.Sink;

import java.util.Map;

public class SimpleLoggerSync extends Logger {

    private String name;

    public SimpleLoggerSync(String name,Map<LoggingLevel, Sink> map){
        super(map);
        this.name = name;
        levelSinkMap.put(LoggingLevel.INFO, FileSink.getFileSink());
    }

    public void debug(String s) {

    }

    public void info(String s) {
        Sink sink = levelSinkMap.get(LoggingLevel.INFO);
        sink.writeData(s);
    }

    public void error(String s) {

    }

    public MyLogger getInfoAppender() {
        return null;
    }
}
