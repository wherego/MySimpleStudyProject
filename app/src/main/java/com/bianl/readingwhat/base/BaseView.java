package com.bianl.readingwhat.base;

/**
 * Created by fhbianling on 2016/10/30.
 *
 * @mail:fhbianling@163.com
 */
public interface BaseView {
    void showLoading();
    void endLoading();
    void showErrorMessage(String message);
}
