package com.bianl.readingwhat.ui.activity.movie.moviedetail;

import android.support.annotation.NonNull;
import android.view.View;

import com.bianl.readingwhat.base.BaseView;
import com.bianl.readingwhat.bean.movie.MovieSubject;

/**
 * Created by fhbianling on 2016/10/31.
 *
 * @mail:fhbianling@163.com
 */
public interface MovieDetailView extends BaseView{
    void showMovieDetail(@NonNull MovieSubject subject);
    View getClickUrlButton();
}
