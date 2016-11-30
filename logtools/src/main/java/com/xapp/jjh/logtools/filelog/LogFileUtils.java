package com.xapp.jjh.logtools.filelog;

import android.annotation.SuppressLint;
import com.xapp.jjh.logtools.config.Constant;
import com.xapp.jjh.logtools.config.XLogConfig;
import java.io.File;
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
		if(config!=null){
			LogFileUtils.config = config;
			allowW = config.isFileLogAllow();
		}
	}

	private static String getFileExtensionName(){
		if(config==null){
			return XLogConfig.DEFAULT_FILE_EXTENSION_NAME;
		}
		return config.getFileExtensionName();
	}

	private static String getLogFileName() {
		return new File(getLogDir(),getNowFileName()).getAbsolutePath();
	}

	private static String getLogFileName(String fileName) {
		return new File(getLogDir(),getNowFileName(fileName)).getAbsolutePath();
	}

	private static String getLogFileNameUnFormatDate(String fileName) {
		return new File(getLogDir(),fileName + getFileExtensionName()).getAbsolutePath();
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
		return getLogTag() + sdf.format(new Date()) + getFileExtensionName();
	}

	private static String getNowFileName(String fileName) {
		SimpleDateFormat sdf = new SimpleDateFormat(dataPattern);
		return getLogTag() + fileName==null?"":(fileName + "-") + sdf.format(new Date()) + getFileExtensionName();
	}

	private static String getLogTag(){
		if(config == null)
			return Constant.normalLogTag;
		return config.getNormalLogTag();
	}

	public static void writeException(Throwable throwable){
		if(throwable!=null){
			writeFile(getLogFileName("Exception"),getExceptionHandledLog(FileUtils.getExceptionContent(throwable)),true);
		}
	}

	public static void writeException(String fileName, Throwable throwable){
		if(throwable!=null){
			writeFile(getLogFileName(fileName),getExceptionHandledLog(FileUtils.getExceptionContent(throwable)),true);
		}
	}
	
	public static void writeLog(String log){
		if(!allowW)
			return;
		writeFile(getLogFileName(), getHandledLog(log),true);
	}

	public static void writeLog(String fileName, String log){
		if(!allowW)
			return;
		writeFile(getLogFileName(fileName), getHandledLog(log),true);
	}

	public static void writeOverWriteLog(String fileName, String log){
		if(!allowW)
			return;
		writeFile(getLogFileNameUnFormatDate(fileName), getHandledLog(log),false);
	}
	
	private static String getHandledLog(String log){
		return "[--" + getNowTime() + "--]" + "\t" + log + "\n\n";
	}

	private static String getExceptionHandledLog(String log){
		return "[--" + getNowTime() + "--]" + "\n" + log + "\n\n";
	}

	private static void writeFile(String fileName, String content, boolean append) {
		FileUtils.writeToFile(fileName,content,append);
	}

}
