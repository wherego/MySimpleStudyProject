package com.bianl.readingwhat.bean;

/**
 * Created by fhbianling on 2016/10/16.
 *
 * @mail:fhbianling@163.com
 */
public class Images {
    /**
     * small : https://img1.doubanio.com/img/celebrity/small/49047.jpg
     * large : https://img1.doubanio.com/img/celebrity/large/49047.jpg
     * medium : https://img1.doubanio.com/img/celebrity/medium/49047.jpg
     */

    private String small;
    private String large;
    private String medium;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
