package com.bianl.readingwhat.bean.movie;

import com.bianl.readingwhat.bean.Images;

import java.util.List;

/**
 * Created by fhbianling on 2016/10/16.
 *
 * @mail:fhbianling@163.com
 */
public class Staff {

    /**
     * alt : https://movie.douban.com/celebrity/1274319/
     * avatars : {"small":"https://img1.doubanio.com/img/celebrity/small/49047.jpg","large":"https://img1.doubanio.com/img/celebrity/large/49047.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/49047.jpg"}
     * name : 张涵予
     * id : 1274319
     */

    private String alt;
    private String name;
    private String id;
    private Images images;

    public Images getImages() {
        return images;
    }
    public void setImages(Images images) {
        this.images = images;
    }
    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
