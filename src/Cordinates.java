public class Cordinates {
    double longitude;
    double latitude;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cordinates that = (Cordinates) o;

        if (Double.compare(that.longitude, longitude) != 0) return false;
        return Double.compare(that.latitude, latitude) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(longitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override

    public String toString() {
        return "Cordinates{" +
                "Longitude=" + longitude +
                ", Latitude=" + latitude +
                '}';
    }

}
