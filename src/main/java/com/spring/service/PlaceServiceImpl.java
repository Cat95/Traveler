package com.spring.service;

import com.spring.dao.PlaceDao;
import com.spring.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("placeService")
@Transactional
public class PlaceServiceImpl implements PlaceService{
    @Autowired
    private PlaceDao dao;

    public void savePlace(Place place) {
        dao.savePlace(place);
    }

    public List<Place> findAllPlaces() {
        return dao.findAllPlaces();
    }

    public void deletePlaceByID(int id) {
        dao.deletePlaceByID(id);
    }

    public Place findByID(int id) {
        return dao.findByID(id);
    }

    public Place findByName(String name) {
        return dao.findByName(name);
    }

    public void updatePlace(Place place) {
        dao.updatePlace(place);
    }

    public List<Place> findByCost(String costType) {
        return dao.findByCost(costType);
    }

    public List<Place> findByRestType(String restType) {
        return dao.findByRestType(restType);
    }

    public List<Place> findByCountry(String country) {
        return dao.findByCountry(country);
    }
}
