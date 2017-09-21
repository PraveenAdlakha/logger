package com.mylogger;

import com.mylogger.logger.ILogger;
import com.mylogger.logger.impl.LoggerFactory;

public class App {
    public static final ILogger I_LOGGER = LoggerFactory.getLogger(App.class.getName());

    public static void main(String[] args) {
        I_LOGGER.info("this is a test message2.");
    }
}
