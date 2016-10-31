package com.bianl.readingwhat.adapter.setting;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bianl.readingwhat.R;
import com.bianl.readingwhat.base.AppBaseAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by fhbianling on 2016/10/18.
 *
 * @mail:fhbianling@163.com
 */
public class AppInfoListAdapter extends com.bianl.readingwhat.base.AppBaseAdapter<PackageInfo,AppInfoViewHolder> {
    private PackageManager pm;

    public AppInfoListAdapter(List<PackageInfo> mData, Activity mActivity) {
        super(mData, mActivity);
    }


    @Override
    protected int getViewId() {
        return R.layout.item_app_info_list;
    }

    @NonNull
    @Override
    protected AppInfoViewHolder getHolder(View convertView) {
        return new AppInfoViewHolder(convertView);
    }

    @Override
    protected void displayData(int position, @NonNull AppInfoViewHolder holder, @NonNull PackageInfo packageInfo) {
        if (holder instanceof AppInfoViewHolder) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            boolean isSystemApp =
                    (applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
            String s = String.valueOf(position) + (isSystemApp ? "SystemApp  " : "SelfInstall  ");
            CharSequence description = applicationInfo.loadDescription(pm) == null ? "" : applicationInfo.loadDescription(pm);
            String s1 = s +
                    "\ndescription:\t\t" +
                    description +
                    "\nlabel:\t\t" + applicationInfo.loadLabel(pm) +
                    "\npackageName:\t\t" + packageInfo.packageName + "\nversionName:\t" + packageInfo.versionName;

            ((AppInfoViewHolder) holder).tv.setText(s1);
        }
    }

}
class AppInfoViewHolder extends AppBaseAdapter.BaseViewHolder {
    @BindView(R.id.item_appInfoList_tv)
    TextView tv;

    public AppInfoViewHolder(View root) {
        super(root);
    }
}
