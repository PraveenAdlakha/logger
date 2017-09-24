package com.mylogger.logger.core;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Properties;

import com.mylogger.logger.ILogger;
import com.mylogger.logger.LoggingLevel;
import com.mylogger.logger.Sink;
import com.mylogger.logger.impl.PropertiesReader;

public abstract class DefaultLogger implements ILogger {

  public Map<LoggingLevel, Sink> getLevelSinkMap() {
    return levelSinkMap;
  }

  //TODO these map should be immutable or pass copy
  private  Map<LoggingLevel, Sink> levelSinkMap;
  private SimpleDateFormat sdf ;

  //TODO add dateformatter and append the message to the write data method

  public DefaultLogger(Map<LoggingLevel, Sink> levelMyLoggerMap) {
    this.levelSinkMap = levelMyLoggerMap;
    Properties properties = PropertiesReader.getPropertiesReader();
    sdf = new SimpleDateFormat(properties.getProperty("ts_format"));
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
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(sdf.format(System.currentTimeMillis())).append(" ")
            .append(level.name()).append(" ").append(message);
    getSinkMap().get(level).writeData(stringBuilder.toString());
  }
}
