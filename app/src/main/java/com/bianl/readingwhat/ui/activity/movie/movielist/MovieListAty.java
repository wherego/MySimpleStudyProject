package com.bianl.readingwhat.ui.activity.movie.movielist;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bianl.readingwhat.R;
import com.bianl.readingwhat.adapter.movie.MovieListAdapter;
import com.bianl.readingwhat.base.BaseActivity;
import com.bianl.readingwhat.bean.MovieBaseList;
import com.bianl.readingwhat.bean.movie.MovieSubject;
import com.bianl.readingwhat.ui.activity.movie.moviedetail.MovieDetailAty;
import com.bianl.readingwhat.ui.activity.movie.moviestared.MovieLikedAty;
import com.bianl.readingwhat.ui.activity.setting.AppInfoListAty;
import com.bianl.readingwhat.util.L;

import java.util.List;

import butterknife.BindView;

/**
 * Created by fhbianling on 2016/10/16.
 *
 * @mail:fhbianling@163.com
 */
public class MovieListAty extends BaseActivity<MovieListPrensent, MovieListModel> implements Toolbar.OnMenuItemClickListener, MovieListView, TabLayout.OnTabSelectedListener, AdapterView.OnItemClickListener {

    public final static int TAG_IN_THEATERS = 0;
    public final static int TAG_COMING_SOON = 1;
    public final static int TAG_US_BOX = 2;

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_movie_list;
    }


    @BindView(R.id.home_list)
    ListView mList;
    @BindView(R.id.home_tabLayout)
    TabLayout mTab;
    private MovieListAdapter adapter;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initView() {
        mTab.addOnTabSelectedListener(this);
        TabLayout.Tab tabAt = mTab.getTabAt(0);
        onTabSelected(tabAt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    public static void startMovieListAty(Activity activity) {
        Intent intent = new Intent(activity, MovieListAty.class);
        activity.startActivity(intent);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_openAppInfo) {
            AppInfoListAty.startAppInfoAty(MovieListAty.this);
            return true;
        } else if (itemId == R.id.action_staredMovie) {
            MovieLikedAty.startMovieLikeAty(this);
            return true;
        }
        return false;
    }

    @Override
    public void showListData(MovieBaseList lists) {
        if (lists == null) {
            return;
        }
        List<MovieSubject> subjects = lists.getSubjects();
        if (adapter == null) {
            adapter = new MovieListAdapter(subjects, this);
            mList.setOnItemClickListener(this);
            mList.setAdapter(adapter);
        } else {
            adapter.resetData(subjects);
        }
    }

    @Override
    public void showLoading() {
        showProgressDialog("Data Loading");
    }

    @Override
    public void endLoading() {
        hideProgress();
    }

    @Override
    public void clear() {
        L.d("clear");
        showListData(new MovieBaseList());
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mPrensenter.switchPresentData(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        MovieSubject item = adapter.getItem(i);
        MovieDetailAty.startMovieDetailAty(this, item.getId());
    }

}