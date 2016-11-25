package com.xapp.jjh.xlog.application;

import android.app.Application;
import android.os.Environment;

import com.xapp.jjh.logtools.config.XLogConfig;
import com.xapp.jjh.logtools.logger.LogLevel;
import com.xapp.jjh.logtools.tools.XLog;

import java.io.File;

/**
 * Created by Taurus on 2016/8/22.
 */
public class DemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        XLog.init(getApplicationContext(),
                new XLogConfig()
                        .setLogLevel(LogLevel.FULL)
                        .setLogDir(new File(Environment.getExternalStorageDirectory(),"TestXLog"))
                        .setSaveCrashLog(true)
                        .setFileLogAllow(true)
                        .setMessageTable(true));
    }
}
