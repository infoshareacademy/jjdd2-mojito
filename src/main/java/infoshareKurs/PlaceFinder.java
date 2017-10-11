package infoshareKurs;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PlaceFinder {

    private final Logger logger = LogManager.getLogger(PlaceFinder.class);

    List<City> cityList;

    public PlaceFinder(List<City> city) {
        this.cityList = city;
    }
    public List<Place> findPlace(GeoLocation geoLocation, double distance) {
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
        if (placelist.size() > 0) {
            String b ="";
            for (Place place : placelist) {
                b = b + "\n" + place.getName();
            }
        }return placelist;
    }
}
