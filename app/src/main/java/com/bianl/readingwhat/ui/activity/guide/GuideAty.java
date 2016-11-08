package com.bianl.readingwhat.ui.activity.guide;

import android.util.Log;

import com.bianl.readingwhat.R;
import com.bianl.readingwhat.base.BaseActivity;
import com.bianl.readingwhat.rx.RxBus;
import com.bianl.readingwhat.ui.activity.movie.movielist.MovieListAty;

import butterknife.OnClick;

public class GuideAty extends BaseActivity {

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_guide_aty;
    }

    @OnClick(R.id.guide_movie)
    protected void goNextPage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("enumTAG","post");
                    Thread.sleep(3000);
                    RxBus.getInstance().post(RxBus.RxEvent.GoMovie);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        MovieListAty.startMovieListAty(this);
    }

    @Override
    protected void initView() {

    }
}
