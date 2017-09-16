

import java.util.ArrayList;
import java.util.List;

public class City {


    private String countryName;

    private Double latitude;

    private Double longitude;

    private String name;

    private List<Place> placeList;

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

    protected Double getLatitude() {
        return latitude;
    }

    protected Double getLongitude() {
        return longitude;
    }

    protected String getName() {
        return name;
    }

    protected List<Place> getPlaceList() {
        return placeList;
    }

    protected String getCountryName() { return countryName;  }
}
