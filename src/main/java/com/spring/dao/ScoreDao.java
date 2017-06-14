package com.spring.dao;

import com.spring.model.Score;

import java.util.List;

public interface ScoreDao {
    void addScore(Score score);

    Score findByID(int id);

    List<Score> findByUserID(int id);

    List<Score> findByPlaceID(int id);

    List<Score> findByRate(int rate);

    boolean exists(int user_id, int place_id);

    int getRate(int user_id, int place_id);

    void updateScore(Score score);
}
