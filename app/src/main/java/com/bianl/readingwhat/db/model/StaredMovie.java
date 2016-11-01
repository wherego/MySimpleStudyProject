package com.bianl.readingwhat.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by fhbianling on 2016/11/1.
 *
 * @mail:fhbianling@163.com
 */
@Entity
public class StaredMovie {
    @Id
    private Long id;
    private String movieId;
    private String smallImage;
    private String title;
    @Generated(hash = 2141977918)
    public StaredMovie(Long id, String movieId, String smallImage, String title) {
        this.id = id;
        this.movieId = movieId;
        this.smallImage = smallImage;
        this.title = title;
    }
    @Generated(hash = 700642271)
    public StaredMovie() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMovieId() {
        return this.movieId;
    }
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
    public String getSmallImage() {
        return this.smallImage;
    }
    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
