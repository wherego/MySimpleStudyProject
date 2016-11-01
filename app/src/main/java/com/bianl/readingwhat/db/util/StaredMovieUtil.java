package com.bianl.readingwhat.db.util;

import com.bianl.readingwhat.bean.Images;
import com.bianl.readingwhat.bean.movie.MovieSubject;
import com.bianl.readingwhat.db.gen.StaredMovieDao;
import com.bianl.readingwhat.db.model.StaredMovie;

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

    public static StaredMovieUtil getInstance() {
        return new StaredMovieUtil();
    }

    public void insert(MovieSubject subject) {
        if (subject == null) {
            return;
        }
        movieDao.insert(subject.asStaredMovie());
    }

    public void insertList(List<MovieSubject> subjects) {
        if (subjects == null) {
            return;
        }
        List<StaredMovie> movies = new ArrayList<>();
        for (int i = 0; i < subjects.size(); i++) {
            movies.add(subjects.get(i).asStaredMovie());
        }
        movieDao.insertInTx(movies);
    }

    public void deleteAll() {
        movieDao.deleteAll();
    }

    public void delete(MovieSubject subject) {
        movieDao.delete(subject.asStaredMovie());
    }

    public StaredMovie query(String id) {
        WhereCondition eq = StaredMovieDao.Properties.MovieId.eq(id);
        return movieDao.queryBuilder().where(eq).unique();
    }

    public List<StaredMovie> queryAll() {
        return movieDao.queryBuilder().list();
    }

}
