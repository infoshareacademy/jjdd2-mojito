package infoshareKurs;

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

    public String findNearestPlace(GeoLocation geoLocation) {
        logger.debug("znalezienie najblizszej stacji od miejsca uzytkownika");
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
        return "Najbliższa stacja rowerowa znajduje się " + lowestDistance + " km od Ciebie. Stacja nazywa się " + this.name;
    }
}