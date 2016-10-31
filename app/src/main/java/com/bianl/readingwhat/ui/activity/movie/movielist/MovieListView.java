package com.bianl.readingwhat.ui.activity.movie.movielist;

import com.bianl.readingwhat.base.BaseView;
import com.bianl.readingwhat.bean.MovieBaseList;

/**
 * Created by fhbianling on 2016/10/30.
 *
 * @mail:fhbianling@163.com
 */
public interface MovieListView extends BaseView{
    void showListData( MovieBaseList lists);
    void clear();
}
