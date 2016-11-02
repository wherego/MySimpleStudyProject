package com.bianl.readingwhat.ui.activity.movie.moviestared;

import com.bianl.readingwhat.base.BaseModel;
import com.bianl.readingwhat.bean.movie.MovieSubject;
import com.bianl.readingwhat.db.model.StaredMovie;
import com.bianl.readingwhat.db.util.StaredMovieUtil;

import java.util.List;

/**
 * Created by fhbianling on 2016/11/2.
 *
 * @mail:fhbianling@163.com
 */
public class MovieLikedModel implements BaseModel {
    public List<StaredMovie> getLikedMovie() {
        return StaredMovieUtil.getInstance().queryAll();
    }

    public void deleteLiked(MovieSubject subject) {
        StaredMovieUtil.getInstance().delete(subject);
    }
}
