import java.util.Date;

public class DistanceMath {

    ///współrzędne punku oraz położenia użytkownika
    // double userCoordinateN, getUserCoordinateE, pointCoordinateN, getPointCoordinateE;



    protected static String countDistance() {
        double distance;

        Double[] userCords = UserCordinates.cordinates();
        Double x = userCords[0];
        Double y = userCords[1];

        Double k = Cordinates.stationCordinate()[0];
        Double j = Cordinates.stationCordinate()[1];


        distance = Math.sqrt(Math.pow((x - k), 2.0)
                + Math.pow((Math.cos((x * Math.PI) / 180.0)
                * (j - y)), 2.0)) * (40075.704 / 360.0);

        return ("Odległość wynosi: " + Math.rint(distance));

    }
}