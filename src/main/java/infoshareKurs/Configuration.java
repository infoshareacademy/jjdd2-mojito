package infoshareKurs;

public class Configuration {

    private String bikeDataPath;
    private String logPath;
    private double cityLatDouble;
    private double cityLngDouble;
    private double placeLatDouble;
    private double placeLngDouble;

    public Configuration() { }

    public double getCityLatDouble() {
        return cityLatDouble;
    }

    public double getCityLngDouble() {
        return cityLngDouble;
    }

    public double getPlaceLatDouble() {
        return placeLatDouble;
    }

    public double getPlaceLngDouble() {
        return placeLngDouble;
    }

    public String getBikeDataPath() {
        return bikeDataPath;
    }

    public String getLogPath() {
        return logPath;
    }
}
