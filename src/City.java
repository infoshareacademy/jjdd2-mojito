

import java.util.ArrayList;
import java.util.List;

public class City {


    private String countryName;

    protected Double latitude;

    protected Double longitude;

    private String name;

    protected List<Place> placeList;

    public City(Double latitude, Double longitude, String name,String country) {
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

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
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
