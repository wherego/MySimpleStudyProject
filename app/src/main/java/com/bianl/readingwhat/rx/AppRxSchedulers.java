package com.bianl.readingwhat.rx;

import com.bianl.readingwhat.util.L;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by fhbianling on 2016/10/30.
 *
 * @mail:fhbianling@163.com
 */
public class AppRxSchedulers {
    public static <T> Observable.Transformer<T, T> ioMain() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        L.d(throwable.getMessage());
                    }
                });
            }
        };
    }
}
