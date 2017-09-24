package com.mylogger.logger.sinks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import com.mylogger.logger.Sink;
import com.mylogger.logger.impl.PropertiesReader;

import static com.mylogger.logger.Constants.FILELOCATION;

public class FileSink implements Sink {
    private static String FILENAME;

    private static FileSink fileSink;

    private static Properties properties ;

    private FileSink(String path){
        FILENAME = path;
    }


    public static synchronized FileSink getSink(){
        properties = PropertiesReader.getPropertiesReader();
        if(fileSink == null){
            fileSink = new FileSink(properties.getProperty(FILELOCATION));
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

            //System.out.println("Done");

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
