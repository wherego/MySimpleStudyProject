package com.bianl.readingwhat.ui.activity.movie.movielist;

import com.bianl.readingwhat.base.BaseModel;
import com.bianl.readingwhat.bean.MovieBaseList;
import com.bianl.readingwhat.net.Api;

import rx.Observable;

/**
 * Created by fhbianling on 2016/10/30.
 *
 * @mail:fhbianling@163.com
 */
public class MovieListModel implements BaseModel {
    public Observable<MovieBaseList> getMovieInTheaters() {
        return Api.getInstance().getMovieInTheaters();
    }

    public Observable<MovieBaseList> getMovieComingSoon() {
        return Api.getInstance().getMovieComingSoon();
    }

    public Observable<MovieBaseList> getMovieUsBox() {
        return Api.getInstance().getMovieUsBox();
    }
}
