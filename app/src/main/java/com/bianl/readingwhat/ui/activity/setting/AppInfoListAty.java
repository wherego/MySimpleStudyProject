package com.bianl.readingwhat.ui.activity.setting;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.widget.ListView;

import com.bianl.readingwhat.R;
import com.bianl.readingwhat.adapter.setting.AppInfoListAdapter;
import com.bianl.readingwhat.base.BaseActivity;

import java.util.List;

import butterknife.BindView;

/**
 * Created by fhbianling on 2016/10/18.
 *
 * @mail:fhbianling@163.com
 */
public class AppInfoListAty extends BaseActivity {
    @Override
    protected int bindLayoutId() {
        return R.layout.activity_app_info;
    }

    @BindView(R.id.appInfo_listV)
    ListView infoShow;

    private AppInfoListAdapter adapter;

    @Override
    protected void initView() {
        PackageManager pm = getPackageManager();
        List<PackageInfo> packages = pm.getInstalledPackages(0);
        adapter = new AppInfoListAdapter(packages, this);
        infoShow.setAdapter(adapter);
    }

    public static void startAppInfoAty(Activity activity) {
        Intent intent = new Intent(activity, AppInfoListAty.class);
        activity.startActivity(intent);
    }
}
