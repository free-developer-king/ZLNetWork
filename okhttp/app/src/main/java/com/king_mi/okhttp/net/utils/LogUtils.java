package com.king_mi.okhttp.net.utils;

import android.util.Log;

/**
 * 日志工具类
 * author liuzl
 * created at 2016/7/7 14:36
 **/
public class LogUtils {

    private static final boolean DEBUG = true;            //控制日志的开关，当为true时，打印日志，false时不打印日志
    private static final String TAG = "framework";
    private static final String BEGIN_TAG = "-------------------------:";

    public static void e(String msg) {
        if (DEBUG) Log.e(TAG, BEGIN_TAG + msg);
    }

    public static void e(String tag, String msg) {
        if (DEBUG) Log.e(tag, BEGIN_TAG + msg);
    }

    public static void e(String tag, String msg, Throwable throwable) {
        if (DEBUG) Log.e(tag, BEGIN_TAG + msg, throwable);
    }

    public static void i(String msg) {
        if (DEBUG) Log.i(TAG, BEGIN_TAG + msg);
    }

    public static void i(String tag, String msg) {
        if (DEBUG) Log.i(tag, BEGIN_TAG + msg);
    }

    public static void i(String tag, String msg, Throwable throwable) {
        if (DEBUG) Log.i(tag, BEGIN_TAG + msg, throwable);
    }

    public static void d(String tag, String msg) {
        if (DEBUG) Log.d(tag, BEGIN_TAG + msg);
    }

    public static void d(String msg) {
        if (DEBUG) Log.d(TAG, BEGIN_TAG + msg);
    }

    public static void v(String msg) {
        if (DEBUG) Log.v(TAG, BEGIN_TAG + msg);
    }

    public static void v(String tag, String msg) {
        if (DEBUG) Log.v(tag, BEGIN_TAG + msg);
    }

    public static void w(Throwable throwable) {
        if (DEBUG) Log.w(TAG, BEGIN_TAG + throwable);
    }

    public static void w(String tag, Throwable throwable) {
        if (DEBUG) Log.w(tag, BEGIN_TAG + throwable);
    }

    public static void print(String msg) {
        if (DEBUG) {
            System.out.println(msg);
        }
    }
}
