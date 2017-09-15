public class Cordinates {
    double Longitude;
    double Latitude;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return Longitude;
    }

    public Cordinates() {
        Longitude = getLongitude();
        Latitude = getLatitude();
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
    protected  double[] userCordinates() {
        double[] wspolrzedne = new double[2];
        System.out.println("Prosze podaj swoje wspolrzedne geograficzne.");
        System.out.println("podaj pierwsza wspolrzedna ");
        Double pierwsza = new UserInputReader().readLine();
        System.out.println("podaj druga wspolrzedna ");
        double druga = new UserInputReader().readLine();
        wspolrzedne[0] = pierwsza;
        wspolrzedne[1] = druga;
        return wspolrzedne;


    }
}
