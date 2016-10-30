package com.bianl.readingwhat.bean.movie;

import com.bianl.readingwhat.bean.Images;

import java.util.List;

/**
 * Created by fhbianling on 2016/10/16.
 *
 * @mail:fhbianling@163.com
 */
@SuppressWarnings("unused")
public class MovieSubject {

    /**
     * rating : {"max":10,"average":8.2,"stars":"40","min":0}
     * genres : ["动作","犯罪"]
     * title : 湄公河行动
     * casts : [{"alt":"https://movie.douban.com/celebrity/1274319/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/49047.jpg","large":"https://img1.doubanio.com/img/celebrity/large/49047.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/49047.jpg"},"name":"张涵予","id":"1274319"},{"alt":"https://movie.douban.com/celebrity/1013782/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1368156632.65.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1368156632.65.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1368156632.65.jpg"},"name":"彭于晏","id":"1013782"},{"alt":"https://movie.douban.com/celebrity/1274640/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/5979.jpg","large":"https://img1.doubanio.com/img/celebrity/large/5979.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/5979.jpg"},"name":"孙淳","id":"1274640"}]
     * collect_count : 170647
     * original_title : 湄公河行动
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1275075/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1372934445.18.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1372934445.18.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1372934445.18.jpg"},"name":"林超贤","id":"1275075"}]
     * year : 2016
     * images : {"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2380677316.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2380677316.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2380677316.jpg"}
     * alt : https://movie.douban.com/subject/25815034/
     * id : 25815034
     */

    private String title;
    private int collect_count;
    private String original_title;
    private String subtype;
    private String year;
    private String alt;
    private String id;
    private List<String> genres;
    private Rating rating;
    private List<Staff> casts;
    private List<Staff> directors;
    private Images images;

    @Override
    public String toString() {
        return "MovieSubject{" +
                "title='" + title + '\'' +
                ", subtype='" + subtype + '\'' +
                ", year='" + year + '\'' +
                ", id='" + id + '\'' +
                ", genres=" + genres +
                '}';
    }

    public Images getImages() {
        return images;
    }
    public void setImages(Images images) {
        this.images = images;
    }

    public List<Staff> getCasts() {
        return casts;
    }

    public void setCasts(List<Staff> casts) {
        this.casts = casts;
    }

    public List<Staff> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Staff> directors) {
        this.directors = directors;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
}
