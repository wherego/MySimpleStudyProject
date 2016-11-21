package com.bianl.readingwhat.ui.activity.movie.moviesearch;

import com.bianl.readingwhat.base.BasePrensenter;
import com.bianl.readingwhat.bean.MovieBaseList;
import com.bianl.readingwhat.rx.AppRxSchedulers;

import rx.Observer;

/**
 * Created by fhbianling on 2016/11/21.
 *
 * @mail:fhbianling@163.com
 */
public class MovieSearchPrensenter extends BasePrensenter<MovieSearchModel, MovieSearchView> {

    public void search(String searchValue) {
        mModel.searchMovie(searchValue).compose(AppRxSchedulers.<MovieBaseList>ioMain()).subscribe(new Observer<MovieBaseList>() {
            @Override
            public void onCompleted() {
                mView.endLoading();
            }

            @Override
            public void onError(Throwable e) {
                mView.endLoading();
                String message = e.getMessage();
                mView.showErrorMessage(message);
            }

            @Override
            public void onNext(MovieBaseList movieBaseList) {
                mView.endLoading();
                mView.showListData(movieBaseList);
            }
        });
    }
}
