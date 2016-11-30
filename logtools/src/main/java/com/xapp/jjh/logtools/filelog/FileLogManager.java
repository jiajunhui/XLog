package com.xapp.jjh.logtools.filelog;

import com.xapp.jjh.logtools.config.XLogConfig;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Taurus on 2016/11/23.
 */

public class FileLogManager {

    private static XLogConfig config;

    public static void init(XLogConfig config){
        FileLogManager.config = config;
        checkClearCycle();
    }

    private static void checkClearCycle() {
        File[] files = getAllFileLog();
        if(files!=null){
            List<File> fileList = Arrays.asList(files);
            Iterator<File> iterators = fileList.iterator();
            while (iterators.hasNext()){
                File file = iterators.next();
                if(file!=null && ((System.currentTimeMillis() - file.lastModified())>=config.getFileClearCycle())){
                    file.delete();
                }
            }
        }
    }

    public static void cleanAllFileLog(){
        File[] files = getAllFileLog();
        if(files!=null){
            for(File file : files){
                file.delete();
            }
        }
    }

    public static void cleanFileLog(String fileName){
        if(config!=null){
            File dir = config.getLogDir();
            if(dir!=null){
                File file = new File(dir,fileName);
                if(file!=null){
                    file.delete();
                }
            }
        }
    }

    public static File[] getAllFileLog(){
        if(config!=null){
            File dir = config.getLogDir();
            if(dir!=null){
                return dir.listFiles();
            }
        }
        return null;
    }
}
