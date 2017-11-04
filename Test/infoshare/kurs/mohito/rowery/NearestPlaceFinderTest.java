package infoshare.kurs.mohito.rowery;

import static org.junit.Assert.*;

import infoshareKurs.City;
import infoshareKurs.GeoLocation;
import infoshareKurs.NearestPlaceFinder;
import infoshareKurs.Place;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NearestPlaceFinderTest {

    @Test
    public void nearestPlaceFinderIsRight() {

        //given
        Place place = new Place("place1", 43.0, 17.0);
        Place place2 = new Place("place2", 43.29, 17.01);
        List<Place> placeList = new ArrayList<>();
        placeList.add(place);
        placeList.add(place2);

        City city = new City(43.0, 17.0, "Nazwa", "PL");
        city.setPlaceList(placeList);

        List<City> cityList = new ArrayList<>();
        cityList.add(city);

        NearestPlaceFinder nearestPlaceFinder = new NearestPlaceFinder(cityList);

        GeoLocation geoLocation = new GeoLocation();
        geoLocation.setLatitiudeUser(43.294980746124);
        geoLocation.setLongitudeUser(17.018170952797);

        Place result = nearestPlaceFinder.findNearestPlace(geoLocation);

        //then
        assertEquals("place2", result);
    }

}