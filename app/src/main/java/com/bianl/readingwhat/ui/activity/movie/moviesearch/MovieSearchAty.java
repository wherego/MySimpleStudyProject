package com.bianl.readingwhat.ui.activity.movie.moviesearch;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.bianl.readingwhat.R;
import com.bianl.readingwhat.adapter.movie.MovieListAdapter;
import com.bianl.readingwhat.base.BaseActivity;
import com.bianl.readingwhat.bean.MovieBaseList;
import com.bianl.readingwhat.bean.movie.MovieSubject;
import com.bianl.readingwhat.ui.activity.movie.moviedetail.MovieDetailAty;

import java.util.List;

import butterknife.BindView;

/**
 * Created by fhbianling on 2016/11/21.
 *
 * @mail:fhbianling@163.com
 */
public class MovieSearchAty extends BaseActivity<MovieSearchPrensenter, MovieSearchModel> implements MovieSearchView, AdapterView.OnItemClickListener, TextView.OnEditorActionListener {
    @BindView(R.id.movie_search_et)
    EditText movieSearchEt;
    @BindView(R.id.movie_search_listView)
    ListView movieSearchListView;

    private MovieListAdapter adapter;

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_movie_search;
    }

    @Override
    protected void initView() {
        movieSearchEt.setOnEditorActionListener(this);
    }

    @Override
    public void showListData(MovieBaseList lists) {
        if (lists == null) {
            return;
        }
        List<MovieSubject> subjects = lists.getSubjects();
        if (adapter == null) {
            adapter = new MovieListAdapter(subjects, this);
            movieSearchListView.setOnItemClickListener(this);
            movieSearchListView.setAdapter(adapter);
        } else {
            adapter.resetData(subjects);
        }
    }

    public static void startMovieSearchAty(Activity activity) {
        Intent intent = new Intent(activity, MovieSearchAty.class);
        activity.startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        MovieSubject item = adapter.getItem(i);
        MovieDetailAty.startMovieDetailAty(this, item.getId());
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_SEARCH) {
            CharSequence text = textView.getText();
            mPrensenter.search(text.toString());
        }
        return false;
    }
}
