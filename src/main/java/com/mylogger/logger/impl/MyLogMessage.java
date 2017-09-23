package com.mylogger.logger.impl;

import com.mylogger.logger.LoggingLevel;

public class MyLogMessage {

    private LoggingLevel loggingLevel;
    private String msg;

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public String getMsg() {
        return msg;
    }

    public MyLogMessage(LoggingLevel loggingLevel, String msg){
        this.loggingLevel = loggingLevel;
        this.msg = msg;
    }
}
