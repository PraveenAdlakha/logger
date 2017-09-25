package com.mylogger.imp;

import com.mylogger.logger.impl.PropertiesReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

import static com.mylogger.logger.Constants.DEBUGSINKTYPE;
import static com.mylogger.logger.Constants.FILELOCATION;
import static com.mylogger.logger.Constants.TSFORMAT;

public class PropertyReaderTest {
    @Test
    public void getPropertyReader(){
        Properties reader = PropertiesReader.getPropertiesReader();
        Assert.assertEquals(reader.getProperty(TSFORMAT),"yyyy-MM-dd HH:mm:ss.SSS");
        Assert.assertEquals(reader.getProperty(FILELOCATION), "/tmp/info.log");
        Assert.assertEquals(reader.getProperty(DEBUGSINKTYPE), "FILE");
    }
}
