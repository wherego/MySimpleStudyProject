package com.bianl.readingwhat.bean;

import com.bianl.readingwhat.bean.movie.MovieSubject;

import java.util.List;

/**
 * Created by fhbianling on 2016/10/16.
 *
 * @mail:fhbianling@163.com
 */
public class MovieBaseList {

    private int count;
    private int start;
    private int total;
    private String title;
    private List<MovieSubject> subjects;

    public List<MovieSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<MovieSubject> subjects) {
        this.subjects = subjects;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
