package infoshareKurs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Country {
    private final Logger logger = LogManager.getLogger();
    private String name;

    private Double latitude;

    private Double longitude;

    public Country(Double latitude, Double longitude, String name, String country) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = country;
    }
}
