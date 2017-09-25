package infoshareKurs;

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
