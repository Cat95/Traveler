package com.spring.model;

import javax.persistence.*;

@Entity
public class Score {
    private int id;
    private int user;
    private int place;
    private int rate;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "User")
    public int getUser() {
        return user;
    }

    public void setUser(int userId) {
        this.user = userId;
    }

    @Basic
    @Column(name = "Place")
    public int getPlace() {
        return place;
    }

    public void setPlace(int placeId) {
        this.place = placeId;
    }

    @Basic
    @Column(name = "Rate")
    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score = (Score) o;

        if (id != score.id) return false;
        if (user != score.user) return false;
        if (place != score.place) return false;
        if (rate != score.rate) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + user;
        result = 31 * result + place;
        result = 31 * result + rate;
        return result;
    }
}
