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
@SuppressWarnings("unused")
public abstract class AppBaseAdapter2<T, E extends AppBaseAdapter2.BaseViewHolder> extends android.widget.BaseAdapter {
    protected Activity mActivity;
    private LayoutInflater inflater;
    protected List<T> mData;

    public AppBaseAdapter2(Activity mActivity) {
        this.mActivity = mActivity;
        inflater = LayoutInflater.from(mActivity);
    }

    public AppBaseAdapter2(List<T> mData, Activity mActivity) {
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

    /**
     * get a ViewHolder and set it as a tag of convertView
     *
     * @param type        assignment by getItemViewType(int position),it has a default value 0;
     * @param convertView the view in the ScrapViews or ActiveViews of a ListView
     * @return a impl of BaseViewHolder
     */
    protected abstract
    @NonNull
    E getHolder(int type, View convertView);

    /**
     * display an entity of a BaseViewHolder at this call.
     *
     * @param position the position of the entity in the list of data
     * @param holder   baseViewHolder
     * @param t        entity
     * @param type     assignment by getItemViewType(int position),it has a default value 0;
     */
    protected abstract void displayData(int position, @NonNull E holder, @NonNull T t, int type);

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return mGetView(i, view, viewGroup);
    }

    /**
     * set a view as convertView of each type
     *
     * @param type     assignment by getItemViewType(int position),it has a default value 0;
     * @param position the position of the view in the list of views
     * @param parent   the view's parent
     * @param inflater a layout inflater defined in the constructor from mContext
     * @return convertView of each type
     */
    protected abstract View getTypeView(int type, int position, ViewGroup parent, LayoutInflater inflater);

    public View mGetView(int i, View view, ViewGroup viewGroup) {
        E holder;
        int type = getItemViewType(i);
        if (view == null) {
            view = getTypeView(type, i, viewGroup, inflater);
            holder = getHolder(type, view);
            view.setTag(holder);
        } else {
            holder = (E) view.getTag();
        }
        T item = getItem(i);
        if (item != null) {
            displayData(i, holder, item, type);
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

    /**
     * BaseViewHolder of this base adapter
     */
    public static abstract class BaseViewHolder {
        protected View root;
        private int type;

        /**
         * if the adapter has only on layout type,use this constructor
         *
         * @param convertView use this holder to save ids of the convertView
         */
        public BaseViewHolder(View convertView) {
            this(convertView, 0);
        }

        /**
         * constructor with type params
         *
         * @param convertView use this holder to save ids of the convertView
         * @param type        type of this holder
         */
        public BaseViewHolder(View convertView, int type) {
            this.root = convertView;
            this.type = type;
            ButterKnife.bind(this, convertView);
        }
    }
}
