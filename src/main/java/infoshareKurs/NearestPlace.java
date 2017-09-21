package infoshareKurs;

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
        System.out.format("Najbliższa stacja rowerowa znajduje się %.2f km od Ciebie. Stacja nazywa się %s"
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
            System.out.format("Nie znaleziono żadnej stacji w odległości %.2f km\n", distance);
        } else {
            System.out.format("Lista stacji w odległości %.2f km\n", distance);
            for (Place place : placelist) {
                System.out.format("%s \n", place.getName());
            }
        }
    }
}