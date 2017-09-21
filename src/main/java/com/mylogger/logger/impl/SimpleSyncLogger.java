package com.mylogger.logger.impl;

import java.util.Map;

import com.mylogger.logger.LoggingLevel;
import com.mylogger.logger.Sink;
import com.mylogger.logger.core.DefaultLogger;

public class SimpleSyncLogger extends DefaultLogger {

  public SimpleSyncLogger(Map<LoggingLevel, Sink> map) {
    super(map);
  }

  @Override
  public void info(String s) {
    super.info(s);
  }
}
