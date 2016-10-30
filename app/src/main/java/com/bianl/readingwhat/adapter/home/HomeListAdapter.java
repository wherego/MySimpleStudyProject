package com.bianl.readingwhat.adapter.home;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bianl.readingwhat.R;
import com.bianl.readingwhat.base.AppBaseAdapter;
import com.bianl.readingwhat.bean.Images;
import com.bianl.readingwhat.bean.movie.MovieSubject;
import com.bianl.readingwhat.util.AppUtil.CommonUtil;
import com.bianl.readingwhat.util.glide.GlideUtil;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by fhbianling on 2016/10/30.
 *
 * @mail:fhbianling@163.com
 */
public class HomeListAdapter extends AppBaseAdapter<MovieSubject> {


    public HomeListAdapter(List<MovieSubject> data, Activity mActivity) {
        super(data, mActivity);
    }

    @Override
    protected int getViewId() {
        return R.layout.item_movie;
    }



    @NonNull
    @Override
    protected BaseViewHolder getHolder(View convertView) {
        return new HomeListHolder(convertView);
    }

    private DecimalFormat df=new DecimalFormat("#0.00");
    @Override
    protected void displayData(int position,@NonNull BaseViewHolder holder, @NonNull MovieSubject movieSubject) {
        if(holder instanceof HomeListHolder){

            String genricsInLine = "Genrics:"+CommonUtil.getGenricsInLine(movieSubject.getGenres());
            ((HomeListHolder) holder).genrecs.setText(genricsInLine);

            String castNameInLine = "Cast:"+CommonUtil.getCastNameInLine(movieSubject.getCasts(), 3);
            ((HomeListHolder) holder).cast.setText(castNameInLine);

            double average = movieSubject.getRating().getAverage();
            String rating = String.format(Locale.CHINA,"Rating:%s", df.format(average));
            ((HomeListHolder) holder).rating.setText(rating);

            Images images = movieSubject.getImages();
            GlideUtil.loadImage(mActivity,images.getMedium(),((HomeListHolder) holder).img);

            ((HomeListHolder) holder).title.setText(movieSubject.getTitle());
            ((HomeListHolder) holder).rank.setText(String.valueOf(position+1));
        }
    }


    private class HomeListHolder extends AppBaseAdapter.BaseViewHolder{
        ImageView img;
        TextView title;
        TextView genrecs;
        TextView rank;
        TextView rating;
        TextView cast;
        public HomeListHolder(View root) {
            super(root);
            img= (ImageView) root.findViewById(R.id.item_movie_img);
            title= (TextView) root.findViewById(R.id.item_movie_title);
            genrecs= (TextView) root.findViewById(R.id.item_movie_genres);
            rank= (TextView) root.findViewById(R.id.item_movie_rank);
            rating= (TextView) root.findViewById(R.id.item_movie_rating);
            cast= (TextView) root.findViewById(R.id.item_movie_cast);
        }
    }
}
