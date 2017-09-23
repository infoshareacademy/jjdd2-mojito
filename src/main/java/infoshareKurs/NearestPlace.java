package infoshareKurs;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NearestPlace {
    private final Logger logger = LogManager.getLogger(NearestPlace.class);

    List<City> cityList;

    public NearestPlace(List<City> city) {
        this.cityList = city;
    }

    private String name;

    public void findNearestPlace(GeoLocation geoLocation) {
        logger.debug("znalezienie najblizszej stacji od uzytkownika");
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
        logger.debug("znalezienie stacji w danym promieniu od uzytkownika");
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