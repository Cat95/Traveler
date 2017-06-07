package com.spring.dao;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ObjectNotFoundException.class)
    public void save(Object entity) {
        getSession().save(entity);
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }
}
