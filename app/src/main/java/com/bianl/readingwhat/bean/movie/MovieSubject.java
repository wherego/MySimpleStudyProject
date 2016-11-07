package com.bianl.readingwhat.bean.movie;

import com.bianl.readingwhat.bean.Images;
import com.bianl.readingwhat.db.model.StaredMovie;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by fhbianling on 2016/10/16.
 *
 * @mail:fhbianling@163.com
 */
@Entity
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

    @Id(autoincrement = true)
    private long _Id;
    private String title;
    @Transient
    private int collect_count;
    @Transient
    private String original_title;
    @Transient
    private String subtype;
    @Transient
    private String year;
    @Transient
    private String alt;
    @Property(nameInDb = "MovieId")
    private String id;
    @Transient
    private List<String> genres;
    @Transient
    private Rating rating;
    @Transient
    private List<Staff> casts;
    @Transient
    private List<Staff> directors;
    @Transient
    private Images images;
    /**
     * reviews_count : 294
     * wish_count : 14951
     * douban_site :
     * mobile_url : https://movie.douban.com/subject/1764796/mobile
     * do_count : null
     * share_url : https://m.douban.com/movie/subject/1764796
     * seasons_count : null
     * schedule_url :
     * episodes_count : null
     * countries : ["美国"]
     * current_season : null
     * summary : 机器人9号（伊利亚•伍德 Elijah Wood 饰）突然醒来，发现身边的世界充满危机，四处残败，一片末世景象。9号带着一个画有三个奇怪符号的圆形物体逃到街上，幸遇发明家机器人2号（马丁•兰道 Martin Landau 饰）给自己装上了声音，但2号却不幸被机器怪兽抓走。9号找到了老兵1号（克里斯托弗•普卢默 Christopher Plummer 饰）、机械工5号（约翰•雷利 John C. Reilly 饰）、疯癫画家6号（克里斯品•格拉夫 Crispin Glover 饰）和大力士8号（弗雷德•塔塔绍尔 Fred Tatasciore 饰）。9号与5号擅自出行援救2号，危急时被女武士7号（詹妮佛•康纳利 Jennifer Connelly 饰）救下，但无意中9号却令终极机器兽复活。带着自己从哪里来以及生存使命的问题，9号决定想尽办法制服机器兽，拯救全世界……©豆瓣
     * comments_count : 11542
     * ratings_count : 57104
     * aka : ["9：末世决战","九","Number 9","机器人9号"]
     */
    @Transient
    private int reviews_count;
    @Transient
    private int wish_count;
    @Transient
    private String douban_site;
    private String mobile_url;
    @Transient
    private String share_url;
    @Transient
    private String schedule_url;
    @Transient
    private String summary;
    @Transient
    private int comments_count;
    @Transient
    private int ratings_count;
    @Transient
    private List<String> countries;
    @Transient
    private List<String> aka;
    /**
     * do_count : null
     * seasons_count : null
     * episodes_count : null
     * current_season : null
     */
    @Transient
    private Object do_count;
    @Transient
    private Object seasons_count;
    @Transient
    private Object episodes_count;
    @Transient
    private Object current_season;


    @Generated(hash = 843260702)
    public MovieSubject(long _Id, String title, String id, String mobile_url) {
        this._Id = _Id;
        this.title = title;
        this.id = id;
        this.mobile_url = mobile_url;
    }

    @Generated(hash = 762160079)
    public MovieSubject() {
    }


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

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public Object getDo_count() {
        return do_count;
    }

    public void setDo_count(Object do_count) {
        this.do_count = do_count;
    }

    public Object getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(Object seasons_count) {
        this.seasons_count = seasons_count;
    }

    public Object getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count) {
        this.episodes_count = episodes_count;
    }

    public Object getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Object current_season) {
        this.current_season = current_season;
    }

    public StaredMovie asStaredMovie(){
        StaredMovie movie=new StaredMovie();
        movie.setMovieId(id);
        if(images!=null){
            movie.setSmallImage(images.getSmall());
        }
        movie.setTitle(title);
        return movie;
    }

    public long get_Id() {
        return this._Id;
    }

    public void set_Id(long _Id) {
        this._Id = _Id;
    }
}
