package com.spring.service;

import com.spring.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    List<User> findAllUsers();

    void deleteUserByID(int ID);

    User findByID(int ID);

    void updateUser(User user);
}
