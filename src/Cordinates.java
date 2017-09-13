public class Cordinates {
    double Longitude;
    double Latitude;


    public double getLongitude() {
        return Longitude;
    }

    public Cordinates(double v, double v1) {
        Longitude = longitude;
        Latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cordinates that = (Cordinates) o;

        if (Double.compare(that.Longitude, Longitude) != 0) return false;
        return Double.compare(that.Latitude, Latitude) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(Longitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(Latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override

    public String toString() {
        return "Cordinates{" +
                "Longitude=" + Longitude +
                ", Latitude=" + Latitude +
                '}';
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }
}
