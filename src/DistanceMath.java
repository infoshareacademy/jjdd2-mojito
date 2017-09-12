import java.util.Date;

public class DistanceMath {

    ///współrzędne punku oraz położenia użytkownika
    // double userCoordinateN, getUserCoordinateE, pointCoordinateN, getPointCoordinateE;



    protected static String countDistance() {
        double distance;

        double[] userCords = UserCordinates.cordinates();
        double x = userCords[0];
        double y = userCords[1];

        double k = Cordinates.stationCordinate()[0];
        double j = Cordinates.stationCordinate()[1];


        distance = Math.sqrt(Math.pow((x - k), 2.0)
                + Math.pow((Math.cos((x * Math.PI) / 180.0)
                * (j - y)), 2.0)) * (40075.704 / 360.0);

        return ("Odległość wynosi: " + Math.rint(distance));

    }
}