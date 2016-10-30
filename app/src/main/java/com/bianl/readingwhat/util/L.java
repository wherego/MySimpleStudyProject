package com.bianl.readingwhat.util;

import android.util.Log;

/**
 * Created by fhbianling on 2016/10/16.
 *
 * @mail:fhbianling@163.com
 */
public class L {
    private L() {

    }

    private static boolean debug;
    private static String tag = "TAG";

    public static void setDebug(boolean isDebug) {
        debug = isDebug;
    }

    public static void setTag(String tag) {
        L.tag = tag;
    }

    public static void d(String message) {
        if (debug) {
            Log.d(tag, message);
        }
    }
    public static void d(Object message) {
        if (debug) {
            Log.d(tag, message.toString());
        }
    }
    public static void e(String messge) {
        if (debug) {
            Log.e(tag, messge);
        }
    }
    public static void e(Object messge) {
        if (debug) {
            Log.e(tag, messge.toString());
        }
    }

}
