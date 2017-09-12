package com.bike;

import java.util.ArrayList;
import java.util.List;

public class City {


    private String countryName;

    private String latitude;

    private String longitude;

    private String name;

    private List<Place> placeList;

    public City(String latitude, String longitude, String name, String country) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.countryName = country;
        this.placeList = new ArrayList<Place>();
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public String getCountryName() { return countryName;  }
}
