package com.mylogger.logger.impl;

import com.mylogger.logger.core.LoggingLevel;
import com.mylogger.logger.core.MyLogger;
import com.mylogger.logger.sinks.Sink;

public class SimpleLoggerSync extends MyLogger {

    public void debug(String s) {

    }

    public void info(String s) {
        Sink sink = levelSinkMap.get(LoggingLevel.INFO);
        sink.writeData(s);
    }

    public void error(String s) {

    }
}
