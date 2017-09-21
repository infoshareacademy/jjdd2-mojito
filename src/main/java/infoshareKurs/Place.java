package infoshareKurs;

import java.util.logging.Logger;

public class Place {
    protected final Logger logger = Logger.getLogger(getClass().getName());

    private String name;

    private GeoLocation geoLocation;

    public Place(String name, double latitiudePlace, double longitudePlace) {

        this.name = name;
        this.latitiudePlace = latitiudePlace;
        this.longitudePlace = longitudePlace;
    }

    protected String getName() {
        return name;
    }

    protected double getLatitiudePlace() {
        return latitiudePlace;
    }

    protected double getLongitudePlace() {
        return longitudePlace;
    }

    private double latitiudePlace;

    private double longitudePlace;
}