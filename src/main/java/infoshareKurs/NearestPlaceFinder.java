package infoshareKurs;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NearestPlaceFinder {
    private final Logger logger = LogManager.getLogger(NearestPlaceFinder.class);

    List<City> cityList;

    public NearestPlaceFinder(List<City> city) {
        this.cityList = city;
    }

    public Place findNearestPlace(GeoLocation geoLocation) {
        logger.debug("znalezienie najbliższej stacji od miejsca użytkownika");
        double lowestDistance = 9999999999999999.9;
        DistanceMath distanceMath = new DistanceMath();

        Place nearestPlace = null;

        for (City city : cityList) {
            for (Place place : city.getPlaceList()) {
                if (lowestDistance > distanceMath.countDistance(place, geoLocation)) {
                    lowestDistance = distanceMath.countDistance(place, geoLocation);
                    nearestPlace = place;
                }
            }
        }

        if (nearestPlace != null) {
            System.out.format("Najbliższa stacja rowerowa znajduje się %.2f km od Ciebie. Stacja nazywa się %s. "
                    , lowestDistance, nearestPlace.getName());
        }

        return nearestPlace;
//        return this.name;
    }


}