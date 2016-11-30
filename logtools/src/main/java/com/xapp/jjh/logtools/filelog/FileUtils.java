package com.xapp.jjh.logtools.filelog;

import android.text.TextUtils;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by Taurus on 2016/11/30.
 */

public class FileUtils {

    public static synchronized void writeToFile(String fileName, String content, boolean append){
        FileOutputStream outputStream = null;
        try {
            if(TextUtils.isEmpty(content) || TextUtils.isEmpty(fileName))
                return;
            outputStream = new FileOutputStream(fileName,append);
            outputStream.write(content.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getExceptionContent(Throwable throwable){
        if(throwable!=null){
            Writer writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            throwable.printStackTrace(printWriter);
            Throwable cause = throwable.getCause();
            while (cause != null) {
                cause.printStackTrace(printWriter);
                cause = cause.getCause();
            }
            printWriter.close();
            return writer.toString();
        }
        return null;
    }
}
