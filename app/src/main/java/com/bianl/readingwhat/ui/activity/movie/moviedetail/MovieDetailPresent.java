package com.bianl.readingwhat.ui.activity.movie.moviedetail;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;

import com.bianl.readingwhat.base.BasePrensenter;
import com.bianl.readingwhat.bean.movie.MovieSubject;
import com.bianl.readingwhat.rx.AppRxSchedulers;
import com.bianl.readingwhat.ui.activity.web.WebtvActivity;

import rx.Observer;
import rx.functions.Action0;

/**
 * Created by fhbianling on 2016/10/31.
 *
 * @mail:fhbianling@163.com
 */
public class MovieDetailPresent extends BasePrensenter<MovieDetailModel, MovieDetailAty> implements View.OnClickListener {

    @Override
    protected void onStart() {
        mView.getClickUrlButton().setOnClickListener(this);
    }

    private String url;

    public void request(String movieSubjectId) {
        mModel.getMovieDetail(movieSubjectId).compose(AppRxSchedulers.<MovieSubject>ioMain()).
                doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mView.showLoading();
                    }
                }).
                subscribe(new Observer<MovieSubject>() {
                    @Override
                    public void onCompleted() {
                        mView.endLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.endLoading();
                        mView.showErrorMessage(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieSubject subject) {
                        url = subject.getMobile_url();
                        mView.endLoading();
                        mView.showMovieDetail(subject);
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (!TextUtils.isEmpty(url)) {
            WebtvActivity.startWebTvActivity(mView, url);
        }
    }
}
