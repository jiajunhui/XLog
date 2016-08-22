package com.xapp.jjh.logtools.filelog;

import android.annotation.SuppressLint;
import com.xapp.jjh.logtools.config.Constant;
import com.xapp.jjh.logtools.config.XLogConfig;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Taurus
 * 文件日志工具
 */
@SuppressLint("SimpleDateFormat")
public class LogFileUtils {
	public static boolean allowW = true;
	private static String dataPattern = "yyyyMMdd";
	private static String timePattern = "HH:mm:ss";
	private static XLogConfig config;

	public static void init(XLogConfig config){
		LogFileUtils.config = config;
	}

	private static String getLogFileName() {
		return new File(getLogDir(),getNowFileName()).getAbsolutePath();
	}

	private static File getLogDir(){
		File dir;
		if(config == null){
			dir = Constant.logDir;
		}else{
			dir = config.getLogDir();
		}
		if(dir!=null && !dir.exists()){
			dir.mkdirs();
		}
		return dir;
	}

	private static String getNowTime() {
		SimpleDateFormat sdf = new SimpleDateFormat(timePattern);
		return sdf.format(new Date());
	}

	private static String getNowFileName() {
		SimpleDateFormat sdf = new SimpleDateFormat(dataPattern);
		return getLogTag() + sdf.format(new Date()) + ".txt";
	}

	private static String getLogTag(){
		if(config == null)
			return Constant.normalLogTag;
		return config.getNormalLogTag();
	}
	
	public static void writeLog(String log){
		if(!allowW)
			return;
		appendMethodB(getLogFileName(), getHandledLog(log));
	}
	
	private static String getHandledLog(String log){
		return getNowTime() + "\t" + log + "\n";
	}

	private synchronized static void appendMethodB(String fileName, String content) {
		try {
			FileWriter writer = new FileWriter(fileName, true);
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
