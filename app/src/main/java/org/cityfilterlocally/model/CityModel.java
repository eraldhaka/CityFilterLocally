package org.cityfilterlocally.model;

import android.support.annotation.NonNull;

/**
 * Created by Erald Haka.
 */
public class CityModel implements Comparable<CityModel>{

    private String country;
    private String name;
    private Integer id;
    private CoordModel coord;

    private String fullName;

    //empty constructor
    public CityModel() {
    }

    public CityModel(String country, String name, Integer id, CoordModel coordModel) {
        this.country = country;
        this.name = name;
        this.id = id;
        this.coord = coordModel;
    }

    public String getCountry() {
        return country;
    }


    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        if (null == fullName) {
            fullName = String.format("%s, %s", getName(), getCountry());
        }
        return fullName;
    }

    public CoordModel getCoord() {
        return coord;
    }


    @Override
    public int compareTo(CityModel cityModel) {
        return getFullName().compareToIgnoreCase(cityModel.getFullName());
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
