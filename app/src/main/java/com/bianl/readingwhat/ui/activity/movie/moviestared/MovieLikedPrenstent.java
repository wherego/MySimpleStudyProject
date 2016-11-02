package com.bianl.readingwhat.ui.activity.movie.moviestared;

import com.bianl.readingwhat.base.BasePrensenter;
import com.bianl.readingwhat.db.model.StaredMovie;

import java.util.List;

/**
 * Created by fhbianling on 2016/11/2.
 *
 * @mail:fhbianling@163.com
 */
public class MovieLikedPrenstent extends BasePrensenter <MovieLikedModel,MovieLikedAty>{
    @Override
    protected void onStart() {
        super.onStart();
        List<StaredMovie> likedMovie = mModel.getLikedMovie();
        mView.showLikedMovie(likedMovie);
    }
}
