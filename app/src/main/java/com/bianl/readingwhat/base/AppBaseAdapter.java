package com.bianl.readingwhat.base;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by fhbianling on 2016/10/30.
 *
 * @mail:fhbianling@163.com
 */
public abstract class AppBaseAdapter<T,E extends AppBaseAdapter.BaseViewHolder> extends android.widget.BaseAdapter {
    protected Activity mActivity;
    protected LayoutInflater inflater;
    protected List<T> mData;

    public AppBaseAdapter(Activity mActivity) {
        this.mActivity = mActivity;
        inflater = LayoutInflater.from(mActivity);
    }

    public AppBaseAdapter(List<T> mData, Activity mActivity) {
        this(mActivity);
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public T getItem(int i) {
        return mData != null ? mData.get(i) : null;
    }

    protected abstract
    @LayoutRes
    int getViewId();

    protected abstract @NonNull E getHolder(View convertView);

    protected abstract void displayData(int position,@NonNull E holder, @NonNull T t);

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return mGetView(i, view, viewGroup);
    }

    public View mGetView(int i, View view, ViewGroup viewGroup) {
        E holder;
        if (view == null) {
            view = inflater.inflate(getViewId(), viewGroup, false);
            holder = getHolder(view);
            view.setTag(holder);
        } else {
            holder = (E) view.getTag();
        }
        T item = getItem(i);
        if(item!=null){
            displayData(i,holder, item);
        }
        return view;
    }

    public void resetData(List<T> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    public void addData(List<T> data) {
        if (mData == null) {
            mData = new ArrayList<>();
        }
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public static abstract class BaseViewHolder {
        protected View root;

        public BaseViewHolder(View root) {
            this.root = root;
            ButterKnife.bind(this,root);
        }
    }
}
