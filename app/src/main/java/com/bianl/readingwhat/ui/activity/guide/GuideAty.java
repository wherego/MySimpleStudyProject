package com.bianl.readingwhat.ui.activity.guide;

import com.bianl.readingwhat.R;
import com.bianl.readingwhat.base.BaseActivity;
import com.bianl.readingwhat.rx.RxBus;
import com.bianl.readingwhat.rx.RxEvent;
import com.bianl.readingwhat.ui.activity.movie.movielist.MovieListAty;
import com.bianl.readingwhat.util.L;

import butterknife.OnClick;

public class GuideAty extends BaseActivity {

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_guide_aty;
    }

    @OnClick(R.id.guide_movie)
    protected void goNextPage() {
        MovieListAty.startMovieListAty(this);
    }

    @Override
    protected void initView() {

    }
}
