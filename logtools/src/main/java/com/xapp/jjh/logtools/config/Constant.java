package com.xapp.jjh.logtools.config;

import android.os.Environment;

import com.xapp.jjh.logtools.logger.LogLevel;

import java.io.File;

/**
 * Created by Taurus on 2016/8/22.
 */
public class Constant {
    public static File logDir = Environment.getExternalStorageDirectory();
    public static String normalLogTag = "FileLog";
    public static String crashLogTag = "CrashLog";
    public static LogLevel logLevel = LogLevel.FULL;
}
