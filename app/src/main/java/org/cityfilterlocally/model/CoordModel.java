package org.cityfilterlocally.model;

/**
 * Created by Erald Haka.
 */
public class CoordModel {
    private double lon;
    private double lat;

    // for gson reflection instantiation
    public CoordModel() {
    }

    public CoordModel(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }
}
