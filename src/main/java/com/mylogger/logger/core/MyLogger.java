package com.mylogger.logger.core;

import com.mylogger.logger.sinks.FileSink;
import com.mylogger.logger.sinks.Sink;

import java.util.Map;

public interface MyLogger {

    public void debug(String s);
    public void info(String s);
    public void error(String s);
    public MyLogger getInfoAppender();
}
