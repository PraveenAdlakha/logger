package com.mylogger.logger.impl;

import com.mylogger.logger.LoggingLevel;
import com.mylogger.logger.Sink;
import com.mylogger.logger.core.DefaultLogger;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SimpleAsyncLogger extends DefaultLogger {

    //TODO read it from executor Pool to get more throuput
    private BlockingQueue<MyLogMessage> queue =  new LinkedBlockingQueue<>();


    public SimpleAsyncLogger(Map<LoggingLevel, Sink> map, String name){
        super(map, name);
        Thread infoThread = new Thread(new MyLogWriter(getLevelSinkMap(), queue));
        infoThread.start();
    }

    @Override
    public void info(String s){
        MyLogMessage logMessage = new MyLogMessage(LoggingLevel.INFO, s, name);
        queue.add(logMessage);
    }

    @Override
    public void debug(String s){
        MyLogMessage logMessage = new MyLogMessage(LoggingLevel.DEBUG, s, name);
        queue.add(logMessage);
    }

    @Override
    public void error(String s){
        MyLogMessage logMessage = new MyLogMessage(LoggingLevel.ERROR, s, name);
        queue.add(logMessage);
    }

}

class MyLogWriter implements Runnable {

    SimpleSyncLogger sink;
    BlockingQueue queue;

    public MyLogWriter(Map<LoggingLevel, Sink> levelSinkMap,
                       BlockingQueue<MyLogMessage> queue){
        sink = new SimpleSyncLogger(levelSinkMap, "thread");
        this.queue = queue;
    }

    @Override
    public void run(){

        while (true){
            try {
                MyLogMessage msg = (MyLogMessage) queue.take();
                if(msg != null){
                    if(msg.getLoggingLevel() == LoggingLevel.INFO)
                    sink.info(msg.getMsg());

                    if(msg.getLoggingLevel() == LoggingLevel.DEBUG)
                        sink.debug(msg.getMsg());

                    if(msg.getLoggingLevel() == LoggingLevel.ERROR)
                        sink.error(msg.getMsg());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
