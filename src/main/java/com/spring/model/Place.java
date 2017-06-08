package com.spring.model;

import javax.persistence.*;

/**
 * Created by User on 07.06.2017.
 */
@Entity
public class Place {
    private int id;
    private String name;
    private String country;
    private String restType;
    private String cost;
    private String description;
    private String image;
    private float rate;

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
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "RestType")
    public String getRestType() {
        return restType;
    }

    public void setRestType(String resyType) {
        this.restType = resyType;
    }

    @Basic
    @Column(name = "Cost")
    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "Rate")
    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (id != place.id) return false;
        if (name != null ? !name.equals(place.name) : place.name != null) return false;
        if (country != null ? !country.equals(place.country) : place.country != null) return false;
        if (restType != null ? !restType.equals(place.restType) : place.restType != null) return false;
        if (cost != null ? !cost.equals(place.cost) : place.cost != null) return false;
        if (description != null ? !description.equals(place.description) : place.description != null) return false;
        if (image != null ? !image.equals(place.image) : place.image != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (restType != null ? restType.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }
}
