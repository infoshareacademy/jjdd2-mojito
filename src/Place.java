

//dodanie dwoch nowych pol - latitude, longtitude
//modyfikacja konstruktora o te dwa nowe pola
//dodanie getterow do tych pol
public class Place {

    private String name;

    public Place(String name,String latitiudePlace, String longitudePlace) {

        this.name = name;
        this.latitiudePlace = latitiudePlace;
        this.longitudePlace = longitudePlace;
    }

    public String getName() {
        return name;
    }

    public String getLatitiudePlace() {
        return latitiudePlace;
    }

    public String getLongitudePlace() {
        return longitudePlace;
    }

    public String latitiudePlace;

    public String longitudePlace;

//    private String place;

}
