package com.spring.dao;

import com.spring.model.Place;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("placeDao")
public class PlaceDaoImpl extends AbstractDao implements PlaceDao {
    public void savePlace(Place place) {
        save(place);
    }

    @SuppressWarnings("unchecked")
    public List<Place> findAllPlaces() {
        Criteria criteria = getSession().createCriteria(Place.class);
        return (List<Place>) criteria.list();
    }

    public void deletePlaceByID(int id) {
        Query query = getSession().createSQLQuery("delete from Place where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public Place findByID(int ID) {
        Criteria criteria = getSession().createCriteria(Place.class);
        criteria.add(Restrictions.eq("id", ID));
        return (Place) criteria.uniqueResult();
    }

    public Place findByName(String name) {
        Criteria criteria = getSession().createCriteria(Place.class);
        criteria.add(Restrictions.eq("name", name));
        return (Place) criteria.uniqueResult();
    }

    public void updatePlace(Place place) {
        getSession().update(place);
    }

    @SuppressWarnings("unchecked")
    public List<Place> findByCountry(String country) {
        return  getSession().createCriteria(Place.class)
                .add(Restrictions.eq("country", country))
                .list();

    }

    @SuppressWarnings("unchecked")
    public List<Place> findByRestType(String restType) {
        return getSession().createCriteria(Place.class)
                .add(Restrictions.eq("restType", restType))
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Place> findByCost(String costType) {
        return getSession().createCriteria(Place.class)
                .add(Restrictions.eq("cost", costType))
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Place> findByRate(int rate) {
        return getSession().createCriteria(Place.class)
                .add(Restrictions.ge("rate", rate))
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Place> findBySameName(String name) {
        return getSession().createCriteria(Place.class)
                .add(Restrictions.like("name","%" + name + "%"))
                .list();
    }
}
