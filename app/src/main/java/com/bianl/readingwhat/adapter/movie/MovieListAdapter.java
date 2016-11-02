package com.bianl.readingwhat.adapter.movie;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bianl.readingwhat.R;
import com.bianl.readingwhat.base.AppBaseAdapter;
import com.bianl.readingwhat.bean.Images;
import com.bianl.readingwhat.bean.movie.MovieSubject;
import com.bianl.readingwhat.db.model.StaredMovie;
import com.bianl.readingwhat.db.util.StaredMovieUtil;
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
public class MovieListAdapter extends AppBaseAdapter<MovieSubject, MovieListHolder> {


    public MovieListAdapter(List<MovieSubject> data, Activity mActivity) {
        super(data, mActivity);
    }

    @Override
    protected int getViewId() {
        return R.layout.item_movie;
    }


    @NonNull
    @Override
    protected MovieListHolder getHolder(View convertView) {
        return new MovieListHolder(convertView, mActivity);
    }

    @Override
    protected void displayData(int position, @NonNull MovieListHolder holder, @NonNull MovieSubject movieSubject) {
        holder.showData(movieSubject, position);
    }


}

class MovieListHolder extends AppBaseAdapter.BaseViewHolder implements View.OnClickListener {
    private Activity mActivity;
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
    @BindView(R.id.item_movie_star)
    CheckedTextView star;

    public MovieListHolder(View root, Activity mActivity) {
        super(root);
        this.mActivity = mActivity;
    }

    private DecimalFormat df = new DecimalFormat("#0.00");

    void showData(MovieSubject movieSubject, int position) {
        String genricsInLine = "Genrics:" + CommonUtil.getGenresInLine(movieSubject.getGenres());
        genrecs.setText(genricsInLine);

        String castNameInLine = "Cast:" + CommonUtil.getCastNameInLine(movieSubject.getCasts(), 3);
        cast.setText(castNameInLine);

        double average = movieSubject.getRating().getAverage();
        String rating = String.format(Locale.CHINA, "Rating:%s", df.format(average));
        this.rating.setText(rating);

        Images images = movieSubject.getImages();
        GlideUtil.loadImage(mActivity, images.getSmall(), img);

        title.setText(movieSubject.getTitle());
        rank.setText(String.valueOf(position + 1));

        StaredMovie query = StaredMovieUtil.getInstance().query(movieSubject.getId());
        star.setChecked(query != null);
        star.setOnClickListener(this);
        star.setTag(movieSubject);
    }

    @Override
    public void onClick(View view) {
        if(view==star){
            star.toggle();
            Object tag = star.getTag();
            if(tag instanceof MovieSubject){
                if(star.isChecked()){
                    StaredMovieUtil.getInstance().insertOrReplace((MovieSubject) tag);
                }else {
                    StaredMovieUtil.getInstance().delete((MovieSubject) tag);
                }
            }
        }
    }
}
