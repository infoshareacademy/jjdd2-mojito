package infoshare.kurs.mohito.rowery;

import java.util.ArrayList;
import java.util.List;

public class NearestPlace {

    List<City> cityList;

    public NearestPlace(List<City> city) {
        this.cityList = city;
    }

    private String name;

    public void findNearestPlace(GeoLocation geoLocation) {
        double lowestDistance = 9999999999999999.9;
        DistanceMath distanceMath = new DistanceMath();

        for (City city : cityList) {
            for (Place place : city.getPlaceList()) {
                if (lowestDistance > distanceMath.countDistance(place, geoLocation)) {
                    lowestDistance = distanceMath.countDistance(place, geoLocation);
                    this.name = place.getName();
                }
            }
        }
        System.out.format("Najblisza stacja rowerowa znajduje sie %.2f km od ciebie . Stacja nazywa sie %s"
                , lowestDistance, this.name);
    }

    public void findPlace(GeoLocation geoLocation, double distance) {
        DistanceMath distanceMath = new DistanceMath();
        List<Place> placelist = new ArrayList<>();
        for (City city : cityList) {
            for (Place place : city.getPlaceList()) {
                double placedistance = distanceMath.countDistance(place, geoLocation);
                if (placedistance <= distance) {
                    placelist.add(place);
                }
            }
        }
        if (placelist.size() == 0) {
            System.out.format("Nie znaleziono zadnej stacji w odleglosci %.2f km\n", distance);
        } else {
            System.out.format("Lista stacji w odległosci %.2f km\n", distance);
            for (Place place : placelist) {
                System.out.format("%s \n", place.getName());
            }
        }
    }
}