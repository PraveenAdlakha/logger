package com.mylogger.logger;

public enum LoggingLevel {
    WARN(5),
    FATAL(4),
    ERROR(3),
    DEBUG(2),
    INFO(1);

    private int level;
    private LoggingLevel (int levelCode) {
        this.level = levelCode;
    }
}
