

//dodanie dwoch nowych pol - latitude, longtitude
//modyfikacja konstruktora o te dwa nowe pola
//dodanie getterow do tych pol
public class Place {

    private String name;

    public Place(String name,double latitiudePlace, double longitudePlace) {

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

//    private String place;

}
