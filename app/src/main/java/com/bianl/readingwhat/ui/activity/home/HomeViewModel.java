package com.bianl.readingwhat.ui.activity.home;

import com.bianl.readingwhat.base.BaseView;
import com.bianl.readingwhat.bean.MovieBaseList;

/**
 * Created by fhbianling on 2016/10/30.
 *
 * @mail:fhbianling@163.com
 */
public interface HomeViewModel extends BaseView{
    void showListData( MovieBaseList lists);
    void showError(String message);
    void showLoading();
    void endLoading();
    void clear();
}
