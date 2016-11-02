package com.bianl.readingwhat.ui.activity.movie.moviestared;

import com.bianl.readingwhat.base.BaseView;
import com.bianl.readingwhat.db.model.StaredMovie;

import java.util.List;

/**
 * Created by fhbianling on 2016/11/2.
 *
 * @mail:fhbianling@163.com
 */
public interface MovieLikedView extends BaseView{
    void showLikedMovie(List<StaredMovie> movies);
}
