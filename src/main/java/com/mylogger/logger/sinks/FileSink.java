package com.mylogger.logger.sinks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.mylogger.logger.Sink;

public class FileSink implements Sink {
    private static String FILENAME;

    private static FileSink fileSink;

    private FileSink(String path){
        FILENAME = path;
    }

    public static synchronized FileSink getFileSink(){
        if(fileSink == null){
            fileSink = new FileSink("/tmp/test.txt");
        }
        return fileSink;
    }

    public void writeData(String msg){
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            String data = "\n"+ msg;

            File file = new File(FILENAME);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // true = append file
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);

            bw.write(data);

            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }

    }

}
