package com.bianl.readingwhat.adapter.movie;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bianl.readingwhat.R;
import com.bianl.readingwhat.base.AppBaseAdapter;
import com.bianl.readingwhat.bean.movie.Staff;
import com.bianl.readingwhat.util.glide.GlideUtil;

import java.util.List;

import butterknife.BindView;

/**
 * Created by fhbianling on 2016/10/31.
 *
 * @mail:fhbianling@163.com
 */
public class StaffAdapter extends AppBaseAdapter<Staff, StaffHolder> {

    public StaffAdapter(List<Staff> mData, Activity mActivity) {
        super(mData, mActivity);
    }

    @Override
    protected int getViewId() {
        return R.layout.item_staff;
    }

    @NonNull
    @Override
    protected StaffHolder getHolder(View convertView) {
        return new StaffHolder(convertView);
    }

    @Override
    protected void displayData(int position, @NonNull StaffHolder holder, @NonNull Staff staff) {
        holder.staffName.setText(staff.getName());
        String small = staff.getAvatars().getSmall();
        GlideUtil.loadImage(mActivity, small, holder.staffAvatar);
    }
}

class StaffHolder extends AppBaseAdapter.BaseViewHolder {
    @BindView(R.id.staff_avatar)
    ImageView staffAvatar;
    @BindView(R.id.staff_name)
    TextView staffName;

    public StaffHolder(View root) {
        super(root);
    }
}
