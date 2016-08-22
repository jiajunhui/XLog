package com.xapp.jjh.logtools.tools;

import android.content.Context;
import com.xapp.jjh.logtools.config.XLogConfig;
import com.xapp.jjh.logtools.crash.CrashHandler;
import com.xapp.jjh.logtools.filelog.LogFileUtils;
import com.xapp.jjh.logtools.logger.AndroidLogTool;
import com.xapp.jjh.logtools.logger.LogLevel;
import com.xapp.jjh.logtools.logger.LogUtil;
import com.xapp.jjh.logtools.logger.Logger;

/**
 * ------------------------------------
 * Created by Taurus on 2016/8/9.
 * ------------------------------------
 */
public class XLog {

    private static boolean messageTable = true;

    private static void initDefaultSetting(LogLevel logLevel){
        Logger.init()                 // default PRETTYLOGGER or use just init()
                .methodCount(3)                 // default 2
                .hideThreadInfo()               // default shown
                .logLevel(logLevel)        // default LogLevel.FULL
                .methodOffset(2)                // default 0
                .logTool(new AndroidLogTool()); // custom log tool, optional
    }

    public static void init(Context context,XLogConfig config){
        messageTable = config.isMessageTable();
        if(config.isSaveCrashLog()){
            CrashHandler.getInstance().init(context,config);
        }
        initDefaultSetting(config.getLogLevel());
        LogFileUtils.init(config);
    }

    public static void d(String message, Object... args) {
        if(messageTable){
            Logger.d(message, args);
        }else{
            LogUtil.d(message,args);
        }
    }

    public static void e(String message, Object... args) {
        if(messageTable){
            Logger.e(null, message, args);
        }else {
            LogUtil.e(message, args);
        }
    }

    public static void e(Throwable throwable, String message, Object... args) {
        if(messageTable){
            Logger.e(throwable, message, args);
        }else{
            LogUtil.e(throwable, message, args);
        }
    }

    public static void i(String message, Object... args) {
        if(messageTable){
            Logger.i(message, args);
        }else{
            LogUtil.i(message, args);
        }
    }

    public static void v(String message, Object... args) {
        if(messageTable){
            Logger.v(message, args);
        }else{
            LogUtil.v(message, args);
        }
    }

    public static void w(String message, Object... args) {
        if(messageTable){
            Logger.w(message, args);
        }else{
            LogUtil.w(message, args);
        }
    }

    /**
     * Formats the json content and print it
     *
     * @param json the json content
     */
    public static void json(String json) {
        Logger.json(json);
    }

    /**
     * Formats the json content and print it
     *
     * @param xml the xml content
     */
    public static void xml(String xml) {
        Logger.xml(xml);
    }

    public static void fileLog(String message){
        LogFileUtils.writeLog(message);
    }

}
