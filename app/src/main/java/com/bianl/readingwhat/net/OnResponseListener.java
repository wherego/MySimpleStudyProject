package com.bianl.readingwhat.net;

/**
 * Created by fhbianling on 2016/10/16.
 *
 * @mail:fhbianling@163.com
 */
public interface OnResponseListener<T> {
    void onSuccessResponse(T t);
    void onFailedResponse();
}
