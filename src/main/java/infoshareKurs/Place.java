package infoshareKurs;


public class Place {

    private String name;

    private String city;

    private GeoLocation geoLocation;

    public Place(String name, double latitiudePlace, double longitudePlace) {

        this.name = name;
        this.latitiudePlace = latitiudePlace;
        this.longitudePlace = longitudePlace;
    }

    public Place(String name, double latitiudePlace, double longitudePlace, String city) {

        this.name = name;
        this.latitiudePlace = latitiudePlace;
        this.longitudePlace = longitudePlace;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public double getLatitudePlace() {
        return latitiudePlace;
    }

    public double getLongitudePlace() {
        return longitudePlace;
    }

    private double latitiudePlace;

    private double longitudePlace;

    public String getCity() {
        return city;
    }
}

