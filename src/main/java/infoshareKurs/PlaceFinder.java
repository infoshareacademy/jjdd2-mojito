package infoshareKurs;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class PlaceFinder {

    private final Logger logger = LogManager.getLogger(PlaceFinder.class);

    List<City> cityList;

    public PlaceFinder(List<City> city) {
        this.cityList = city;
    }

    private String name;

    public String findNearestPlace(GeoLocation geoLocation) {
        logger.debug("znalezienie najblizszej stacji od miejsca uzytkownika");
        double lowestDistance = Double.MAX_VALUE;
        DistanceMath distanceMath = new DistanceMath();

        for (City city : cityList) {
            for (Place place : city.getPlaceList()) {
                if (lowestDistance > distanceMath.countDistance(place, geoLocation)) {
                    lowestDistance = distanceMath.countDistance(place, geoLocation);
                    this.name = place.getName();
                }
            }
        }
        return "Najbliższa stacja rowerowa znajduje się " + lowestDistance + " km od Ciebie. Stacja nazywa się " + this.name;
    }
}
