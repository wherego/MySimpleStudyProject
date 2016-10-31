package com.bianl.readingwhat.ui.activity.movie.moviedetail;

import com.bianl.readingwhat.base.BaseModel;
import com.bianl.readingwhat.bean.movie.MovieSubject;
import com.bianl.readingwhat.net.Api;

import rx.Observable;

/**
 * Created by fhbianling on 2016/10/31.
 *
 * @mail:fhbianling@163.com
 */
public class MovieDetailModel implements BaseModel {
    public Observable<MovieSubject> getMovieDetail(String movieSubjectId) {
        return Api.getInstance().getMovieDetail(movieSubjectId);
    }
}
