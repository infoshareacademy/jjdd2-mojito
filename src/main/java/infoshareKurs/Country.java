package infoshareKurs;

import java.util.logging.Logger;

public class Country {
    protected final Logger logger = Logger.getLogger(getClass().getName());
    private String name;

    private Double latitude;

    private Double longitude;

    public Country(Double latitude, Double longitude, String name, String country) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = country;
    }
}
