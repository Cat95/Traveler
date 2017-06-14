package com.spring.dao;


import com.spring.model.Place;

import java.util.List;

public interface PlaceDao {
    void savePlace(Place place);

    List<Place> findAllPlaces();

    void deletePlaceByID(int id);

    Place findByID(int id);

    Place findByName(String name);

    void updatePlace(Place place);

    List<Place> findByCost(String costType);

    List<Place> findByRestType(String restType);

    List<Place> findByCountry(String country);

    List<Place> findByRate(int rate);

    List<Place> findBySameName(String name);
}
