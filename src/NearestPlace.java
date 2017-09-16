public class NearestPlace {
    private String name;

    public void findNearestPlace(GeoLocation geoLocation, BikeParsing data) {
        double lowestDistance = 9999999900.0;
        DistanceMath distanceMath = new DistanceMath();

        for (City city : data.getCityList()) {
            for (Place place : city.getPlaceList()) {
                if (lowestDistance > distanceMath.countDistance(place, geoLocation)) {
                    lowestDistance = distanceMath.countDistance(place, geoLocation);
                    this.name = place.getName();
                }

            }
        }
        System.out.format("Najblisza stacja rowerowa znajduje sie %.2f km od ciebie . Stacja nazywa sie %s"
                , lowestDistance,this.name);
    }
}
