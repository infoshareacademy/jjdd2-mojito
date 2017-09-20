package main.bikeProject;

public class DistanceMath {

    protected double countDistance(Place place, GeoLocation geoLocation) {
        double distance;

        double x = geoLocation.latitiudeUser;
        double y = geoLocation.longitudeUser;

        double k = place.getLatitiudePlace();
        double j = place.getLongitudePlace();

        distance = Math.sqrt(Math.pow((x - k), 2.0)
                + Math.pow((Math.cos((x * Math.PI) / 180.0)
                * (j - y)), 2.0)) * (40075.704 / 360.0);

        return (distance);
    }
}