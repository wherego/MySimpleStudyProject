package com.bianl.readingwhat.rx;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by fhbianling on 2016/10/30.
 *
 * @mail:fhbianling@163.com
 */
public class RxBus {
    private Subject<RxEvent, RxEvent> mBus;

    private static class RxBusHolder {
        final static RxBus instance = new RxBus();
    }

    private RxBus() {
        mBus = new SerializedSubject<>(PublishSubject.<RxEvent>create());
    }

    public static RxBus getInstance() {
        return RxBusHolder.instance;
    }

    public void post(RxEvent event) {
        mBus.onNext(event);
    }

    public Observable<RxEvent> toObservable() {
        return mBus;
    }

    public enum RxEvent {
        GoMovie,
        GoBook
    }
}
