package com.xapp.jjh.logtools.tools;

import com.xapp.jjh.logtools.logger.LogUtil;

/**
 * Created by Taurus on 2016/11/29.
 */

public class MethodStack {

    private static final int CALLER_START_INDEX = 2;

    public static void printMethodCallStack(){
        StackTraceElement[] caller = new Throwable().getStackTrace();
        if(caller!=null){
            int len = caller.length;
            for(int i=0;i<len;i++){
                if(i<CALLER_START_INDEX)
                    continue;
                StackTraceElement stackTraceElement = caller[i];
                LogUtil.d(stackTraceElement.getClassName() + "-->" + stackTraceElement.getMethodName() + "-->(" + stackTraceElement.getLineNumber() + ")");
            }
        }
    }
}
