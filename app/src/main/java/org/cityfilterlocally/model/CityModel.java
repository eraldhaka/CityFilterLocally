package org.cityfilterlocally.model;

/**
 * Created by Erald Haka.
 */
public class CityModel implements Comparable<CityModel>{

    private String country;
    private String name;
    private Integer id;
    private CoordModel coordModel;

    private String fullName;

    //empty constructor
    public CityModel() {
    }

    public CityModel(String country, String name, Integer id, CoordModel coordModel) {
        this.country = country;
        this.name = name;
        this.id = id;
        this.coordModel = coordModel;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        if (null == fullName) {
            fullName = String.format("%s, %s", getName(), getCountry());
        }
        return fullName;
    }

    public CoordModel getCoord() {
        return coordModel;
    }

    public void setCoord(CoordModel coordModel) {
        this.coordModel = coordModel;
    }

    @Override
    public int compareTo(CityModel cityModel) {
        return getFullName().compareToIgnoreCase(cityModel.getFullName());
    }

    @Override
    public String toString() {
        return name;
    }
}
