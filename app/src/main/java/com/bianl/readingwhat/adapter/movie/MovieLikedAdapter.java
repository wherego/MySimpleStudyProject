package com.bianl.readingwhat.adapter.movie;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bianl.readingwhat.R;
import com.bianl.readingwhat.base.AppBaseAdapter;
import com.bianl.readingwhat.db.model.StaredMovie;
import com.bianl.readingwhat.util.glide.GlideUtil;

import java.util.List;

import butterknife.BindView;

/**
 * Created by fhbianling on 2016/11/2.
 *
 * @mail:fhbianling@163.com
 */
public class MovieLikedAdapter extends AppBaseAdapter<StaredMovie, MovieLikedHolder> {
    public MovieLikedAdapter(List<StaredMovie> mData, Activity mActivity) {
        super(mData, mActivity);
    }

    @Override
    protected int getViewId() {
        return R.layout.item_stared_movie;
    }

    @NonNull
    @Override
    protected MovieLikedHolder getHolder(View convertView) {
        return new MovieLikedHolder(convertView, mActivity);
    }

    @Override
    protected void displayData(int position, @NonNull MovieLikedHolder holder, @NonNull StaredMovie staredMovie) {
        holder.showData(staredMovie);
    }
}

class MovieLikedHolder extends AppBaseAdapter.BaseViewHolder {
    private final Activity mActivity;
    @BindView(R.id.staredMovieImg)
    ImageView staredMovieImg;
    @BindView(R.id.staredMovieTitle)
    TextView staredMovieTitle;

    public MovieLikedHolder(View root, Activity mActivity) {
        super(root);
        this.mActivity = mActivity;
    }

    public void showData(StaredMovie staredMovie) {
        GlideUtil.loadImage(mActivity, staredMovie.getSmallImage(), staredMovieImg);
        staredMovieTitle.setText(staredMovie.getTitle());
    }
}
