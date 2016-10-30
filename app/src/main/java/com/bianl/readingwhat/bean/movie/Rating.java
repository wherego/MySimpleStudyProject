package com.bianl.readingwhat.bean.movie;

/**
 * Created by fhbianling on 2016/10/16.
 *
 * @mail:fhbianling@163.com
 */
public class Rating {

    /**
     * max : 10
     * average : 8.2
     * stars : 40
     * min : 0
     */

    private int max;
    private double average;
    private String stars;
    private int min;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
