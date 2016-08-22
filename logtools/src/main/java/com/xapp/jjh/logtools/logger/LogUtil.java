/*
 * Copyright (c) 2013. wyouflf (wyouflf@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xapp.jjh.logtools.logger;

import android.text.TextUtils;
import android.util.Log;

/**
 * Log工具，类似android.util.Log。
 * tag自动产生，格式: customTagPrefix:className.methodName(L:lineNumber),
 * customTagPrefix为空时只输出：className.methodName(L:lineNumber)。
 */
public class LogUtil {
    public static boolean allowLog = true;
    public static String customTagPrefix = "";
    private LogUtil() {
    }

    private static String generateTag() {
        StackTraceElement caller = new Throwable().getStackTrace()[2];
        String tag = "%s.%s(L:%d)";
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        tag = String.format(tag, callerClazzName, caller.getMethodName(), caller.getLineNumber());
        tag = TextUtils.isEmpty(customTagPrefix) ? tag : customTagPrefix + ":" + tag;
        return tag;
    }

    private static String generateMessage(String content, Object... args){
        return args.length == 0?content:String.format(content, args);
    }

    public static void d(String content, Object... args) {
        if (!allowLog) return;
        String tag = generateTag();
        Log.d(tag, generateMessage(content, args));
    }

    public static void d(Throwable tr,String content, Object... args) {
        if (!allowLog) return;
        String tag = generateTag();

        Log.d(tag, generateMessage(content, args), tr);
    }

    public static void e(String content,Object... args) {
        if (!allowLog) return;
        String tag = generateTag();

        Log.e(tag, generateMessage(content, args));
    }

    public static void e(Throwable tr,String content, Object... args) {
        if (!allowLog) return;
        String tag = generateTag();

        Log.e(tag, generateMessage(content, args), tr);
    }

    public static void i(String content, Object... args) {
        if (!allowLog) return;
        String tag = generateTag();

        Log.i(tag, generateMessage(content, args));
    }

    public static void i(Throwable tr,String content, Object... args) {
        if (!allowLog) return;
        String tag = generateTag();

        Log.i(tag, generateMessage(content, args), tr);
    }

    public static void v(String content, Object... args) {
        if (!allowLog) return;
        String tag = generateTag();

        Log.v(tag, generateMessage(content, args));
    }

    public static void v(Throwable tr,String content, Object... args) {
        if (!allowLog) return;
        String tag = generateTag();

        Log.v(tag, generateMessage(content, args), tr);
    }

    public static void w(String content, Object... args) {
        if (!allowLog) return;
        String tag = generateTag();

        Log.w(tag, generateMessage(content, args));
    }

    public static void w(Throwable tr,String content, Object... args) {
        if (!allowLog) return;
        String tag = generateTag();

        Log.w(tag, generateMessage(content, args), tr);
    }

    public static void w(Throwable tr) {
        if (!allowLog) return;
        String tag = generateTag();

        Log.w(tag, tr);
    }


    public static void wtf(String content) {
        if (!allowLog) return;
        String tag = generateTag();

        Log.wtf(tag, content);
    }

    public static void wtf(String content, Throwable tr) {
        if (!allowLog) return;
        String tag = generateTag();

        Log.wtf(tag, content, tr);
    }

    public static void wtf(Throwable tr) {
        if (!allowLog) return;
        String tag = generateTag();

        Log.wtf(tag, tr);
    }

}
