package com.mylogger.imp;

import com.mylogger.logger.ILogger;
import com.mylogger.logger.impl.LoggerFactory;
import com.mylogger.logger.impl.PropertiesReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

import static com.mylogger.logger.Constants.TSFORMAT;


public class LoggerFactoryTests {

    @Test
    public void getLoggerTest(){
        ILogger logger = LoggerFactory.getLogger(this.getClass().getName());
        Assert.assertEquals(logger.getSinkMap().size(), 3);
    }




}

