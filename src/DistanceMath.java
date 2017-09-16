import java.util.Date;

public class DistanceMath {

    ///współrzędne punku oraz położenia użytkownika
    // double userCoordinateN, getUserCoordinateE, pointCoordinateN, getPointCoordinateE;



    protected  Double countDistance(Place place, GeoLocation geoLocation) {
        double distance;

        double x = geoLocation.latitiudeUser;
        double y = geoLocation.longitudeUser;

        double k = place.getLatitiudePlace();
        double j = place.getLongitudePlace();


        distance = Math.sqrt(Math.pow((x - k), 2.0)
                + Math.pow((Math.cos((x * Math.PI) / 180.0)
                * (j - y)), 2.0)) * (40075.704 / 360.0);

        return Double.valueOf(("Odległość wynosi: " + Math.rint(distance)));

    }
}