package com.mylogger;

import com.mylogger.logger.impl.LoggerFactory;
import com.mylogger.logger.core.MyLogger;

public class App {
    public static final MyLogger logger = LoggerFactory.getLogger(App.class.getName());

    public static void main(String[] args) {
        logger.info("this is a test message.");
    }
}
