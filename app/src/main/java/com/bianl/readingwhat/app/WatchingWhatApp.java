package com.bianl.readingwhat.app;

import android.app.Application;
import android.content.pm.ResolveInfo;

import com.bianl.readingwhat.entites.Cnst;
import com.bianl.readingwhat.util.L;

/**
 * Created by fhbianling on 2016/10/16.
 *
 * @mail:fhbianling@163.com
 */
public class WatchingWhatApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        L.setDebug(true);
        L.setTag(Cnst.tag);
    }
}
