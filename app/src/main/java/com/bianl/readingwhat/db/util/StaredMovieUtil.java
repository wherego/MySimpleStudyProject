package com.bianl.readingwhat.db.util;

import com.bianl.readingwhat.bean.Images;
import com.bianl.readingwhat.bean.movie.MovieSubject;
import com.bianl.readingwhat.db.gen.StaredMovieDao;
import com.bianl.readingwhat.db.model.StaredMovie;
import com.bianl.readingwhat.util.L;

import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fhbianling on 2016/11/1.
 *
 * @mail:fhbianling@163.com
 */
public class StaredMovieUtil extends AbsDaoUtil {
    private StaredMovieDao movieDao;

    private StaredMovieUtil() {
        movieDao = daoSession.getStaredMovieDao();
    }

    private static class StaredMovieUtilHolder {
        private final static StaredMovieUtil instance = new StaredMovieUtil();
    }

    public static StaredMovieUtil getInstance() {
        return StaredMovieUtilHolder.instance;
    }

    public void insert(MovieSubject subject) {
        mInsertOrReplace(subject,false);
    }

    public void insertOrReplace(MovieSubject subject){
        mInsertOrReplace(subject,true);
    }

    private void mInsertOrReplace(MovieSubject subject,boolean canReplace){
        if(subject==null){
            return;
        }
        L.d("insert:"+subject.getTitle());
        if(canReplace){
            movieDao.insertOrReplace(subject.asStaredMovie());
        }else {
            movieDao.insert(subject.asStaredMovie());
        }
    }

    public void insertList(List<MovieSubject> subjects) {
        mInsertOrReplaceList(subjects,false);
    }
    public void insertOrReplaceList(List<MovieSubject> subjects){
        mInsertOrReplaceList(subjects,true);
    }

    private void mInsertOrReplaceList(List<MovieSubject> subjects,boolean canReplace){
        if (subjects == null) {
            return;
        }
        List<StaredMovie> movies = new ArrayList<>();
        for (int i = 0; i < subjects.size(); i++) {
            movies.add(subjects.get(i).asStaredMovie());
        }
        if(canReplace){
            movieDao.insertOrReplaceInTx(movies);
        }else {
            movieDao.insertInTx(movies);
        }
    }
    public void deleteAll() {
        movieDao.deleteAll();
    }

    public void delete(MovieSubject subject) {
        StaredMovie query = query(subject.getId());
        if(query!=null){
            L.d("delete:"+subject.getTitle());
            movieDao.delete(query);
        }
    }

    public StaredMovie query(String id) {
        WhereCondition eq = StaredMovieDao.Properties.MovieId.eq(id);
        return movieDao.queryBuilder().where(eq).unique();
    }

    public StaredMovie query(MovieSubject subject){
        return query(subject.getId());
    }

    public List<StaredMovie> queryAll() {
        return movieDao.queryBuilder().list();
    }

}
