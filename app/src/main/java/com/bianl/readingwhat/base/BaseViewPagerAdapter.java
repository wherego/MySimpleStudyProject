package com.bianl.readingwhat.base;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fhbianling on 2016/10/30.
 *
 * @mail:fhbianling@163.com
 */
public abstract class BaseViewPagerAdapter<T> extends PagerAdapter {
    private Context mContext;
    protected List<T> mData;
    protected List<View> mViewList;

    public BaseViewPagerAdapter(Context mContext, List<T> mData) {
        this.mContext = mContext;
        this.mData = mData;
        mViewList = new ArrayList<>();
        if (mData != null) {
            for (int i = 0; i < mData.size(); i++) {
                View view = getView(i, mData.get(i));
                mViewList.add(view);
            }
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mViewList.get(position);
        container.addView(view);
        return view;
    }

    protected abstract View getView(int position, T t);

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViewList.get(position));
    }

    public void resetData(List<T> list){

    }
}
