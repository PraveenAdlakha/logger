package com.mylogger.logger.sinks;

public class Test {

    public static void main(String[] args) {
        FileSink fileSink = FileSink.getFileSink();
        int i=0;
        while (++i != 5)
        fileSink.writeData("This is test");
    }
}
