package com.spring.service;

import com.spring.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void saveUser(User user);

    List<User> findAllUsers();

    void deleteUserByID(int ID);

    User findByID(int ID);

    User findByLogin(String login);

    void updateUser(User user);
}
