package com.mylogger.logger.core;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Properties;

import com.mylogger.logger.ILogger;
import com.mylogger.logger.LoggingLevel;
import com.mylogger.logger.Sink;
import com.mylogger.logger.impl.PropertiesReader;

import static com.mylogger.logger.Constants.TSFORMAT;

public abstract class DefaultLogger implements ILogger {

  public Map<LoggingLevel, Sink> getLevelSinkMap() {
    return levelSinkMap;
  }

  //TODO these map should be immutable or pass copy
  private  Map<LoggingLevel, Sink> levelSinkMap;
  private SimpleDateFormat sdf ;
  public String name;

  //TODO add dateformatter and append the message to the write data method

  public DefaultLogger(Map<LoggingLevel, Sink> levelMyLoggerMap, String name) {
    this.levelSinkMap = levelMyLoggerMap;
    this.name = name;
    Properties properties = PropertiesReader.getPropertiesReader();
    sdf = new SimpleDateFormat(properties.getProperty(TSFORMAT));
  }

  @Override
  public Map<LoggingLevel, Sink> getSinkMap() {
    return levelSinkMap;
  }

  public void debug(String s) {
    log(LoggingLevel.DEBUG, s, name);
  }

  public void info(String s) {
    log(LoggingLevel.INFO, s, name);
  }

  public void error(String s) {
    log(LoggingLevel.ERROR, s, name);
  }

  private synchronized void log(LoggingLevel level, String message, String name) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(sdf.format(System.currentTimeMillis())).append(" ")
            .append(name).append(" ").append(level.name()).append(" ").append(message);
    getSinkMap().get(level).writeData(stringBuilder.toString());
  }
}
