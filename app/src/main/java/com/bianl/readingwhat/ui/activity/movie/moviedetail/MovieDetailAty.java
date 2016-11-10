package com.bianl.readingwhat.ui.activity.movie.moviedetail;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bianl.readingwhat.R;
import com.bianl.readingwhat.adapter.movie.StaffAdapter;
import com.bianl.readingwhat.base.BaseActivity;
import com.bianl.readingwhat.bean.movie.MovieSubject;
import com.bianl.readingwhat.bean.movie.Staff;
import com.bianl.readingwhat.db.model.StaredMovie;
import com.bianl.readingwhat.db.util.StaredMovieUtil;
import com.bianl.readingwhat.rx.RxEvent;
import com.bianl.readingwhat.util.AppUtil.CommonUtil;
import com.bianl.readingwhat.util.L;
import com.bianl.readingwhat.util.glide.GlideUtil;
import com.bianl.readingwhat.view.NestedGridView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by fhbianling on 2016/10/31.
 *
 * @mail:fhbianling@163.com
 */
public class MovieDetailAty extends BaseActivity<MovieDetailPresent, MovieDetailModel> implements MovieDetailView {
    @Override
    protected int bindLayoutId() {
        return R.layout.activity_movie_detail;
    }

    @Override
    protected void initView() {
        String extra = getIntent().getStringExtra(START_STRING);
        mPrensenter.request(extra);
        itemMovieRank.setVisibility(View.GONE);
        itemMovieCast.setVisibility(View.GONE);
    }

    @BindView(R.id.item_movie_rank)
    TextView itemMovieRank;
    @BindView(R.id.item_movie_img)
    ImageView itemMovieImg;
    @BindView(R.id.item_movie_title)
    TextView itemMovieTitle;
    @BindView(R.id.item_movie_rating)
    TextView itemMovieRating;
    @BindView(R.id.item_movie_genres)
    TextView itemMovieGenres;
    @BindView(R.id.item_movie_cast)
    TextView itemMovieCast;
    @BindView(R.id.movie_detail_summary)
    TextView movieDetailSummary;
    @BindView(R.id.movie_detail_directory)
    NestedGridView movieDetailDirectory;
    @BindView(R.id.movie_detail_cast)
    NestedGridView movieDetailCast;

    @BindView(R.id.movie_detail_collect)
    TextView movieDetailCollect;
    @BindView(R.id.movie_detail_wish)
    TextView movieDetailWish;
    @BindView(R.id.movie_detail_review)
    TextView movieDetailReview;
    @BindView(R.id.movie_detail_url)
    TextView movieDetailUrl;
    @BindView(R.id.item_movie_star)
    CheckedTextView star;
    private StaffAdapter directoryAdapter;
    private StaffAdapter castAdapter;

    @Override
    public void showMovieDetail(@NonNull MovieSubject subject) {
        StaredMovie query = StaredMovieUtil.getInstance().query(subject);
        star.setChecked(query!=null);
        star.setClickable(false);
        String medium = subject.getImages().getMedium();
        GlideUtil.loadImageWithOrginScale(this, medium, itemMovieImg);

        movieDetailCollect.setText(String.valueOf(subject.getCollect_count()));
        movieDetailReview.setText(String.valueOf(subject.getReviews_count()));
        movieDetailWish.setText(String.valueOf(subject.getWish_count()));

        itemMovieTitle.setText(subject.getTitle());
        itemMovieRating.setText(String.valueOf(subject.getRating().getAverage()));
        String genresInLine = CommonUtil.getGenresInLine(subject.getGenres());
        itemMovieGenres.setText(genresInLine);
        movieDetailSummary.setText(String.format(getString(R.string.u3000_u3000_s), subject.getSummary()));
        List<Staff> directors = subject.getDirectors();
        List<Staff> casts = subject.getCasts();
        if (directoryAdapter == null) {
            directoryAdapter = new StaffAdapter(directors, this);
            movieDetailDirectory.setAdapter(directoryAdapter);
        } else {
            directoryAdapter.resetData(directors);
        }
        if (castAdapter == null) {
            castAdapter = new StaffAdapter(casts, this);
            movieDetailCast.setAdapter(castAdapter);
        } else {
            castAdapter.resetData(casts);
        }
    }

    @Override
    public View getClickUrlButton() {
        return movieDetailUrl;
    }

    public static void startMovieDetailAty(Activity activity, String movieSubjectId) {
        Intent intent = new Intent(activity, MovieDetailAty.class);
        intent.putExtra(START_STRING, movieSubjectId);
        activity.startActivity(intent);
    }

    @Override
    protected void handleMessage(RxEvent rxEvent) {
        L.d(this.getLocalClassName()+" receiver:"+rxEvent);
    }
}
