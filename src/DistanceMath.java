import java.util.Date;

public class DistanceMath {

    ///współrzędne punku oraz położenia użytkownika
    // double userCoordinateN, getUserCoordinateE, pointCoordinateN, getPointCoordinateE;



    protected  Double countDistance(Place place, GeoLocation myLocation) {
        double distance;
        double[] stationCordin = new double[2];

        double[] userCords = UserCordinates.cordinates();

        double x = userCords[0];
        double y = userCords[1];

        double k = stationCordin[0];
        double j = stationCordin[1];

        place.getLatitiudePlace();
        place.getLongitudePlace();



        distance = Math.sqrt(Math.pow((x - k), 2.0)
                + Math.pow((Math.cos((x * Math.PI) / 180.0)
                * (j - y)), 2.0)) * (40075.704 / 360.0);

        return ("Odległość wynosi: " + Math.rint(distance));

    }
}