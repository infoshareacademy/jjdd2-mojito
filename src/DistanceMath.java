
public class DistanceMath {

    ///współrzędne punku oraz położenia użytkownika
    // double userCoordinateN, getUserCoordinateE, pointCoordinateN, getPointCoordinateE;



    protected static Double countDistance() {
        double distance;

        double[] stationcordin = new double[2];

        double[] userCords = new Cordinates().userCordinates();

        double x = userCords[0];
        double y = userCords[1];

        double k = stationcordin[0];
        double j = stationcordin[1];


        distance = Math.sqrt(Math.pow((x - k), 2.0)
                + Math.pow((Math.cos((x * Math.PI) / 180.0)
                * (j - y)), 2.0)) * (40075.704 / 360.0);

        return Double.valueOf(("Odległość wynosi: " + Math.rint(distance)));

    }
}