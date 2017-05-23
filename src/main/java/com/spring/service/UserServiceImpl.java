package com.spring.service;

import com.spring.dao.UserDao;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    public void saveUser(User user) {
        dao.saveUser(user);
    }

    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    public void deleteUserByID(int ID) {
        dao.deleteUserByID(ID);
    }

    public User findByID(int ID) {
        return dao.findByID(ID);
    }

    public void updateUser(User user) {
        dao.updateUser(user);
    }
}
