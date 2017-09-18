public class GeoLocation {

    protected double latitiudeUser;

    protected double longitudeUser;

    public double getLatitiudePlace() {
        return latitiudeUser;
    }

    public double getLongitudePlace() {
        return longitudeUser;
    }

    public GeoLocation() {
        double[] wspolrzedne = new double[2];
        System.out.println("Prosze podaj swoje wspolrzedne geograficzne.");
        System.out.println("podaj pierwsza wspolrzedna ");
        Double  pierwsza = new UserInputReader().readLine();
        System.out.println("podaj druga wspolrzedna ");
        double druga = new UserInputReader().readLine();
        wspolrzedne[0] = pierwsza;
        wspolrzedne[1] = druga;
        this.latitiudeUser = wspolrzedne[0];
        this.longitudeUser = wspolrzedne[1];
    }
}
