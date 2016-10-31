package com.bianl.readingwhat.net;

import com.bianl.readingwhat.bean.MovieBaseList;
import com.bianl.readingwhat.bean.movie.MovieSubject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by fhbianling on 2016/10/16.
 *
 * @mail:fhbianling@163.com
 */
public interface request {
    String BASE_URL = "https://api.douban.com/";

    @GET("v2/movie/in_theaters")
    Observable<MovieBaseList> getMovieInTheaters();

    @GET("v2/movie/coming_soon")
    Observable<MovieBaseList> getMovieComingSoon();

    @GET("v2/movie/us_box")
    Observable<MovieBaseList> getMovieUsBox();

    @GET("v2/movie/subject/{movieSubjectId}")
    Observable<MovieSubject> getMovieDetail(@Path("movieSubjectId") String movieSubjectId);
}
