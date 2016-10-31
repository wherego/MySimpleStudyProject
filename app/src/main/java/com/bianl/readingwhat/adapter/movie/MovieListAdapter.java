package com.bianl.readingwhat.adapter.movie;

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

import butterknife.BindView;

/**
 * Created by fhbianling on 2016/10/30.
 *
 * @mail:fhbianling@163.com
 */
public class MovieListAdapter extends AppBaseAdapter<MovieSubject,HomeListHolder> {


    public MovieListAdapter(List<MovieSubject> data, Activity mActivity) {
        super(data, mActivity);
    }

    @Override
    protected int getViewId() {
        return R.layout.item_movie;
    }



    @NonNull
    @Override
    protected HomeListHolder getHolder(View convertView) {
        return new HomeListHolder(convertView);
    }

    private DecimalFormat df=new DecimalFormat("#0.00");
    @Override
    protected void displayData(int position,@NonNull HomeListHolder holder, @NonNull MovieSubject movieSubject) {

        String genricsInLine = "Genrics:"+CommonUtil.getGenricsInLine(movieSubject.getGenres());
        holder.genrecs.setText(genricsInLine);

        String castNameInLine = "Cast:"+CommonUtil.getCastNameInLine(movieSubject.getCasts(), 3);
        holder.cast.setText(castNameInLine);

        double average = movieSubject.getRating().getAverage();
        String rating = String.format(Locale.CHINA,"Rating:%s", df.format(average));
        holder.rating.setText(rating);

        Images images = movieSubject.getImages();
        GlideUtil.loadImage(mActivity,images.getSmall(),((HomeListHolder) holder).img);

        holder.title.setText(movieSubject.getTitle());
        holder.rank.setText(String.valueOf(position+1));
    }


}
class HomeListHolder extends AppBaseAdapter.BaseViewHolder{
    @BindView(R.id.item_movie_img)
    ImageView img;
    @BindView(R.id.item_movie_title)
    TextView title;
    @BindView(R.id.item_movie_genres)
    TextView genrecs;
    @BindView(R.id.item_movie_rank)
    TextView rank;
    @BindView(R.id.item_movie_rating)
    TextView rating;
    @BindView(R.id.item_movie_cast)
    TextView cast;
    public HomeListHolder(View root) {
        super(root);
    }
}
