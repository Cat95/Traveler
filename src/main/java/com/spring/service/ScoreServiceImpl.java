package com.spring.service;

import com.spring.dao.ScoreDao;
import com.spring.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("scoreService")
@Transactional
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreDao dao;

    public void addScore(Score score) {
        dao.addScore(score);
    }

    public Score findByID(int id) {
        return dao.findByID(id);
    }

    public List<Score> findByUserID(int id) {
        return dao.findByUserID(id);
    }

    public List<Score> findByPlaceID(int id) {
        return dao.findByPlaceID(id);
    }

    public List<Score> findByRate(int rate) {
        return dao.findByRate(rate);
    }

    public boolean exists(int user_id, int place_id) {
        return dao.exists(user_id, place_id);
    }

    public void updateScore(Score score) {
        dao.updateScore(score);
    }

    public int getRate(int user_id, int place_id) {
        return dao.getRate(user_id, place_id);
    }
}
