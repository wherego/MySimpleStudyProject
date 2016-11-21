package com.bianl.readingwhat.ui.activity.movie.moviesearch;

import com.bianl.readingwhat.base.BaseModel;
import com.bianl.readingwhat.bean.MovieBaseList;
import com.bianl.readingwhat.net.Api;

import rx.Observable;

/**
 * Created by fhbianling on 2016/11/21.
 *
 * @mail:fhbianling@163.com
 */
public class MovieSearchModel implements BaseModel {

    public Observable<MovieBaseList> searchMovie(String searchKey) {
        return Api.getInstance().searchMovie(searchKey);
    }
}
