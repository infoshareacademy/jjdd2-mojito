package infoshareKurs;


public class Place {

    private String name;

    private GeoLocation geoLocation;

    public Place(String name, double latitiudePlace, double longitudePlace) {

        this.name = name;
        this.latitiudePlace = latitiudePlace;
        this.longitudePlace = longitudePlace;
    }

    public String getName() {
        return name;
    }

    public double getLatitiudePlace() {
        return latitiudePlace;
    }

    public double getLongitudePlace() {
        return longitudePlace;
    }

    private double latitiudePlace;

    private double longitudePlace;
}
