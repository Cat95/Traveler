package com.spring.dao;

import com.spring.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {

    public void saveUser(User user) {
        persist(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = getSession().createCriteria(User.class);
        return (List<User>) criteria.list();
    }

    public void deleteUserByID(int id) {
        Query query = getSession().createSQLQuery("delete from User where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public User findByID(int ID) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("id", ID));
        return (User) criteria.uniqueResult();
    }

    public void updateUser(User user) {
        getSession().update(user);
    }
}
