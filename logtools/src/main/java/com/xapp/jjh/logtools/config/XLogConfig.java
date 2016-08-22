package com.xapp.jjh.logtools.config;

import android.text.TextUtils;
import com.xapp.jjh.logtools.logger.LogLevel;
import java.io.File;

/**
 * Created by Taurus on 2016/8/22.
 */
public class XLogConfig {
    private File logDir = Constant.logDir;
    private String normalLogTag = Constant.normalLogTag;
    private String crashLogTag = Constant.crashLogTag;
    private LogLevel logLevel = Constant.logLevel;
    private boolean saveCrashLog = true;
    private boolean messageTable = true;

    public File getLogDir() {
        return logDir;
    }

    public XLogConfig setLogDir(File logDir) {
        if(logDir!=null){
            this.logDir = logDir;
        }
        return this;
    }

    public String getNormalLogTag() {
        return normalLogTag;
    }

    public XLogConfig setNormalLogTag(String normalLogTag) {
        if(!TextUtils.isEmpty(normalLogTag)){
            this.normalLogTag = normalLogTag;
        }
        return this;
    }

    public String getCrashLogTag() {
        return crashLogTag;
    }

    public XLogConfig setCrashLogTag(String crashLogTag) {
        if(!TextUtils.isEmpty(crashLogTag)){
            this.crashLogTag = crashLogTag;
        }
        return this;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public XLogConfig setLogLevel(LogLevel logLevel) {
        if(logLevel!=null){
            this.logLevel = logLevel;
        }
        return this;
    }

    public boolean isSaveCrashLog() {
        return saveCrashLog;
    }

    public XLogConfig setSaveCrashLog(boolean saveCrashLog) {
        this.saveCrashLog = saveCrashLog;
        return this;
    }

    public boolean isMessageTable() {
        return messageTable;
    }

    public XLogConfig setMessageTable(boolean messageTable) {
        this.messageTable = messageTable;
        return this;
    }
}
