package com.bianl.readingwhat.app;

import android.app.Application;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

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
    public boolean isNetworkActivate() {
        ConnectivityManager connectivityManager = getConnectivityManager();
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return null != activeNetworkInfo && activeNetworkInfo.isConnectedOrConnecting();
    }

    private ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);
    }

    public boolean isWifiEnable() {
        ConnectivityManager connectivityManager = getConnectivityManager();
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null
                && activeNetworkInfo.isAvailable()
                && activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI;
    }
}
