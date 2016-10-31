package com.bianl.readingwhat.ui.activity.movie.movielist;

import com.bianl.readingwhat.base.BasePrensenter;
import com.bianl.readingwhat.bean.MovieBaseList;
import com.bianl.readingwhat.rx.AppRxSchedulers;

import java.util.HashMap;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

import static com.bianl.readingwhat.ui.activity.movie.movielist.MovieListAty.TAG_COMING_SOON;
import static com.bianl.readingwhat.ui.activity.movie.movielist.MovieListAty.TAG_IN_THEATERS;
import static com.bianl.readingwhat.ui.activity.movie.movielist.MovieListAty.TAG_US_BOX;

/**
 * Created by fhbianling on 2016/10/30.
 *
 * @mail:fhbianling@163.com
 */
public class MovieListPrensent extends BasePrensenter<MovieListModel, MovieListAty> {
    private HashMap<Integer, MovieBaseList> cache = new HashMap<>();

    void switchPresentData(final int position) {
        MovieBaseList movieBaseList = cache.get(position);
        if (movieBaseList == null) {
            request(position);
        } else {
            mView.showListData(movieBaseList);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void request(final int position) {
        Observable<MovieBaseList> data = null;
        switch (position) {
            case TAG_IN_THEATERS:
                data = mModel.getMovieInTheaters();
                break;
            case TAG_COMING_SOON:
                data = mModel.getMovieComingSoon();
                break;
            case TAG_US_BOX:
                data = mModel.getMovieUsBox();
                break;
        }
        if (data != null) {
            data.compose(AppRxSchedulers.<MovieBaseList>ioMain()).doOnSubscribe(new Action0() {
                @Override
                public void call() {
                    mView.showLoading();
                }
            }).subscribe(new Action1<MovieBaseList>() {
                @Override
                public void call(MovieBaseList movieBaseList) {
                    mView.showListData(movieBaseList);
                    cache.put(position, movieBaseList);
                }
            }, new Action1<Throwable>() {
                @Override
                public void call(Throwable throwable) {
                    mView.showErrorMessage(throwable.getMessage());
                    mView.endLoading();
                    mView.clear();
                }
            }, new Action0() {
                @Override
                public void call() {
                    mView.endLoading();
                }
            });
        }
    }
}
