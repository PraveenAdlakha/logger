package com.mylogger.logger.sinks;

import com.mylogger.logger.Sink;
import com.mylogger.logger.impl.PropertiesReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MemorySink implements Sink {

    public static List<String> getList() {
        return list;
    }

    private static List<String> list ;

    @Override
    public void writeData(String msg) {
        if(list == null){
            list = new ArrayList<>();
        }
        list.add(msg);
    }
}
