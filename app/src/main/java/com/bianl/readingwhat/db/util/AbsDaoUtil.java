package com.bianl.readingwhat.db.util;

import com.bianl.readingwhat.app.WatchingWhatApp;
import com.bianl.readingwhat.db.gen.DaoMaster;
import com.bianl.readingwhat.db.gen.DaoSession;

/**
 * Created by fhbianling on 2016/11/1.
 *
 * @mail:fhbianling@163.com
 */
public abstract class AbsDaoUtil {
    protected DaoSession daoSession;
    protected AbsDaoUtil() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(WatchingWhatApp.getInstance(), "wwa_db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

}
