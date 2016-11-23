package com.xapp.jjh.logtools.filelog;

import com.xapp.jjh.logtools.config.XLogConfig;
import java.io.File;

/**
 * Created by Taurus on 2016/11/23.
 */

public class FileLogManager {

    private static XLogConfig config;

    public static void init(XLogConfig config){
        FileLogManager.config = config;
    }

    public static void cleanAllFileLog(){
        if(config!=null){
            File dir = config.getLogDir();
            if(dir!=null){
                File[] files = dir.listFiles();
                if(files!=null){
                    for(File file : files){
                        file.delete();
                    }
                }
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
