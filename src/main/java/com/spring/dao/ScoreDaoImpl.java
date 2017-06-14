package com.spring.dao;

import com.spring.model.Score;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("scoreDao")
public class ScoreDaoImpl extends AbstractDao implements ScoreDao {
    public void addScore(Score score) {
        save(score);
    }

    public Score findByID(int id) {
        return (Score) getSession().createCriteria(Score.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Score> findByUserID(int id) {
        return getSession().createCriteria(Score.class)
                .add(Restrictions.eq("user", id))
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Score> findByPlaceID(int id) {
        return getSession().createCriteria(Score.class)
                .add(Restrictions.eq("place", id))
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Score> findByRate(int rate) {
        return getSession().createCriteria(Score.class)
                .add(Restrictions.ge("rate", rate))
                .list();
    }

    @SuppressWarnings("unchecked")
    public boolean exists(int user_id, int place_id) {
        List<Score> list = getSession().createCriteria(Score.class)
                .add(Restrictions.eq("user", user_id))
                .add(Restrictions.eq("place", place_id))
                .list();

        return list.size() > 0;
    }

    public int getRate(int user_id, int place_id) {
        Score score = (Score) getSession().createCriteria(Score.class)
                .add(Restrictions.eq("user", user_id))
                .add(Restrictions.eq("place", place_id))
                .uniqueResult();

        return score.getRate();
    }

    public void updateScore(Score score) {
        getSession().update(score);
    }
}
