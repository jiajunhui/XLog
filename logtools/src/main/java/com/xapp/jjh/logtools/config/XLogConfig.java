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
    public static final String DEFAULT_FILE_EXTENSION_NAME = ".txt";
    private String fileExtensionName = DEFAULT_FILE_EXTENSION_NAME;
    public static final long DEFAULT_FILE_CLEAR_CYCLE = 7*24*60*60*1000;//a week
    private long mFileClearCycle = DEFAULT_FILE_CLEAR_CYCLE;
    private boolean saveCrashLog = true;
    private boolean messageTable = true;
    private boolean fileLogAllow = false;

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

    public boolean isFileLogAllow() {
        return fileLogAllow;
    }

    public XLogConfig setFileLogAllow(boolean fileLogAllow) {
        this.fileLogAllow = fileLogAllow;
        return this;
    }

    public String getFileExtensionName() {
        if(TextUtils.isEmpty(fileExtensionName)){
            return DEFAULT_FILE_EXTENSION_NAME;
        }
        return fileExtensionName;
    }

    public XLogConfig setFileExtensionName(String fileExtensionName) {
        this.fileExtensionName = fileExtensionName;
        return this;
    }

    public long getFileClearCycle() {
        if(mFileClearCycle<=0){
            mFileClearCycle = DEFAULT_FILE_CLEAR_CYCLE;
        }
        return mFileClearCycle;
    }

    public XLogConfig setFileClearCycle(long fileClearCycle) {
        this.mFileClearCycle = fileClearCycle;
        return this;
    }
}
