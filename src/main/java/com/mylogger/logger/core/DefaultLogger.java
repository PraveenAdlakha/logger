package com.mylogger.logger.core;

import java.util.Map;

import com.mylogger.logger.ILogger;
import com.mylogger.logger.LoggingLevel;
import com.mylogger.logger.Sink;

public abstract class DefaultLogger implements ILogger {

  //TODO these map should be immutable or pass copy
  private  Map<LoggingLevel, Sink> levelSinkMap;

  //TODO add dateformatter and append the message to the write data method

  public void DefaultLogger(Map<LoggingLevel, Sink> levelSinkMap){
    this.levelSinkMap = levelSinkMap;
  }

  public DefaultLogger(Map<LoggingLevel, Sink> levelMyLoggerMap) {
    this.levelSinkMap = levelMyLoggerMap;
  }

  @Override
  public Map<LoggingLevel, Sink> getSinkMap() {
    return levelSinkMap;
  }

  public void debug(String s) {
    log(LoggingLevel.DEBUG, s);
  }

  public void info(String s) {
    log(LoggingLevel.INFO, s);
  }

  public void error(String s) {
    log(LoggingLevel.ERROR, s);
  }

  private synchronized void log(LoggingLevel level, String message) {
    getSinkMap().get(level).writeData(message);
  }
}
