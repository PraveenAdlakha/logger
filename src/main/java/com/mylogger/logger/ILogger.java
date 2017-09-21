package com.mylogger.logger;

import java.util.Map;

public interface ILogger {

  public void debug(String s);

  public void info(String s);

  public void error(String s);

  public Map<LoggingLevel, Sink> getSinkMap();
}
