package com.mylogger.imp;

import com.mylogger.logger.ILogger;
import com.mylogger.logger.impl.LoggerFactory;
import com.mylogger.logger.sinks.MemorySink;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IntegrationTest {
    public static final ILogger I_LOGGER = LoggerFactory.getLogger(IntegrationTest.class.getName());

    @Test
    public void MemorySinkTest(){
        I_LOGGER.warn("This is memory sink test.");
        List list = MemorySink.getList();
        String str = (String) list.get(list.size()-1);
        Assert.assertEquals(true,str.contains("This is memory sink test."));
        //System.out.println(list.get(list.size()-1));
    }
}
