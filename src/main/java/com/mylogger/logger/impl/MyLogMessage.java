package com.mylogger.logger.impl;

import com.mylogger.logger.LoggingLevel;

public class MyLogMessage {

    private LoggingLevel loggingLevel;
    private String msg;
    private String name;

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public String getMsg() {
        return msg;
    }

    public MyLogMessage(LoggingLevel loggingLevel, String msg, String name){
        this.loggingLevel = loggingLevel;
        this.msg = msg;
        this.name = name;
    }
}
