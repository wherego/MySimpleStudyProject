package com.bianl.readingwhat.ui.activity.movie.moviestared;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;

import com.bianl.readingwhat.R;
import com.bianl.readingwhat.adapter.movie.MovieLikedAdapter;
import com.bianl.readingwhat.base.BaseActivity;
import com.bianl.readingwhat.db.model.StaredMovie;
import com.bianl.readingwhat.util.L;

import java.util.List;

import butterknife.BindView;

/**
 * Created by fhbianling on 2016/11/2.
 *
 * @mail:fhbianling@163.com
 */
public class MovieLikedAty extends BaseActivity<MovieLikedPrenstent, MovieLikedModel> implements MovieLikedView {
    @Override
    protected int bindLayoutId() {
        return R.layout.activity_simple_grid;
    }

    @BindView(R.id.simpleGirdView)
    GridView mGrid;

    @Override
    protected void initView() {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
    }

    private MovieLikedAdapter adapter;

    @Override
    public void showLikedMovie(List<StaredMovie> movies) {
        L.d(movies.size() + "");
        if (adapter == null) {
            adapter = new MovieLikedAdapter(movies, this);
            mGrid.setAdapter(adapter);
        } else {
            adapter.resetData(movies);
        }
    }

    public static void startMovieLikeAty(Activity activity) {
        Intent intent = new Intent(activity, MovieLikedAty.class);
        activity.startActivity(intent);
    }
}
