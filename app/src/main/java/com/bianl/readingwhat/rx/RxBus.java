package com.bianl.readingwhat.rx;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by fhbianling on 2016/10/30.
 *
 * @mail:fhbianling@163.com
 */
public class RxBus {

    private static class RxBusHolder {
        final static RxBus INSTANCE = new RxBus();
    }

    private final Subject<Object, Object> mBusSubject = new SerializedSubject<>(PublishSubject.create());

    public static RxBus getInstance() {
        return RxBusHolder.INSTANCE;
    }

    public Observable<Object> toObservable() {
        return mBusSubject;
    }

    public void post(Object event) {
        mBusSubject.onNext(event);
    }
}

