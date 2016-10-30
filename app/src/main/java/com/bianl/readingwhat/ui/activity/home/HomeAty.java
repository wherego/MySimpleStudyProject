package com.bianl.readingwhat.ui.activity.home;

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
import android.widget.ListView;

import com.bianl.readingwhat.R;
import com.bianl.readingwhat.adapter.home.HomeListAdapter;
import com.bianl.readingwhat.base.BaseActivity;
import com.bianl.readingwhat.bean.MovieBaseList;
import com.bianl.readingwhat.bean.movie.MovieSubject;
import com.bianl.readingwhat.ui.activity.setting.AppInfoListAty;
import com.bianl.readingwhat.util.L;

import java.util.List;

import butterknife.BindView;

/**
 * Created by fhbianling on 2016/10/16.
 *
 * @mail:fhbianling@163.com
 */
public class HomeAty extends BaseActivity<HomePrensent, HomeModel> implements Toolbar.OnMenuItemClickListener, HomeViewModel, TabLayout.OnTabSelectedListener {

    public final static int TAG_IN_THEATERS = 0;
    public final static int TAG_COMING_SOON = 1;
    public final static int TAG_US_BOX = 2;

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_home;
    }


    @BindView(R.id.home_toolbar)
    Toolbar toolbar;
    @BindView(R.id.home_list)
    ListView mList;
    @BindView(R.id.home_tabLayout)
    TabLayout mTab;
    private HomeListAdapter adapter;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initView() {
        toolBarSetting();
        mTab.addOnTabSelectedListener(this);
        TabLayout.Tab tabAt = mTab.getTabAt(0);
        onTabSelected(tabAt);
    }

    private void toolBarSetting() {
        toolbar.setTitle("ReadingWhat");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            toolbar.setBackground(new ColorDrawable(getResources().getColor(R.color.colorAccent)));
        }
        toolbar.setSubtitle("a study demo");
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    public static void startHomeAty(Activity activity) {
        Intent intent = new Intent(activity, HomeAty.class);
        activity.startActivity(intent);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int itemId = item.getItemId();
        L.d("OnClick");
        if (itemId == R.id.action_openAppInfo) {
            L.d("OnClick");
            AppInfoListAty.startAppInfoAty(HomeAty.this);
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
            adapter = new HomeListAdapter(subjects, this);
            mList.setAdapter(adapter);
        } else {
            adapter.resetData(subjects);
        }
    }

    @Override
    public void showError(String message) {
        showMsg(message);
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
}