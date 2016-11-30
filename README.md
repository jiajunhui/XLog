# XLog
android log tools , include message log,format json log,file log ,crash log
Configration
====
```java
public class DemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        XLog.init(getApplicationContext(),
                new XLogConfig()
                        //loglevel FULL为显示log ，NONE为不显示log
                        .setLogLevel(LogLevel.FULL)
                        //文件日志以及崩溃日志文件的目录
                        .setLogDir(new File(Environment.getExternalStorageDirectory(),"TestXLog"))
                        //崩溃日志文件标记名称
                        .setCrashLogTag("CrashLogTag")
                        //是否云保存文件日志（非crash日志）
                        .setFileLogAllow(true)
                        //普通文件日志标记名称
                        .setNormalLogTag("NormalLogTag")
                        //日志文件扩展名，默认.txt
                        .setFileExtensionName(XLogConfig.DEFAULT_FILE_EXTENSION_NAME)
                        //日志文件定期清理周期（单位毫秒），默认为一周（7*24*60*60*1000）
                        .setFileClearCycle(XLogConfig.DEFAULT_FILE_CLEAR_CYCLE)
                        //是否保存崩溃日志
                        .setSaveCrashLog(true)
                        //是否为普通日志信息添加消息框
                        .setMessageTable(true));
    }
}
```
