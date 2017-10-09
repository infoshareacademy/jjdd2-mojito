package infoshareKurs;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String countryName;

    private Double latitude;

    private Double longitude;

    private String name;

    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }

    private List<Place> placeList;

    public City(Double latitude, Double longitude, String name, String country) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.countryName = country;
        this.placeList = new ArrayList<Place>();
    }

    @Override
    public String toString() {
        return name + "[" +
                latitude +
                "/" + longitude +
                ']';
    }

    protected Double getLatitude() {
        return latitude;
    }

    protected Double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public String getCountryName() {
        return countryName;
    }
}
