package infoshare.kurs.mohito.rowery;

public class Country {
    private String name;

    private Double latitude;

    private Double longitude;

    public Country(Double latitude, Double longitude, String name, String country) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = country;
    }
}
