package com.bianl.readingwhat.base;

/**
 * Created by fhbianling on 2016/10/30.
 *
 * @mail:fhbianling@163.com
 */
public abstract class BasePrensenter<M, V> {
    public M mModel;
    public V mView;

    public void setMv(M m, V v) {
        this.mModel = m;
        this.mView = v;
        onStart();
    }

    protected void viewControl(){}
    protected void onStart(){}
}
