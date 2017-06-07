package com.spring.dao;

import com.spring.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    List<User> findAllUsers();

    void deleteUserByID(int id);

    User findByID(int id);

    User findByLogin(String login);

    void updateUser(User user);
}

