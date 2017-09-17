public class GeoLocation {

    protected double latitiudeUser;

    protected double longitudeUser;

    public double getLatitiudeUser() {
        return latitiudeUser;
    }

    public double getLongitudeUser() {
        return longitudeUser;
    }

    public double[] geoLocation() {
        double[] wspolrzedne = new double[2];
        System.out.println("Prosze podaj swoje wspolrzedne geograficzne.");
        System.out.println("podaj pierwsza wspolrzedna ");
        double pierwsza = new UserInputReader().readLineDouble();
        System.out.println("podaj druga wspolrzedna ");
        double druga = new UserInputReader().readLineDouble();
        wspolrzedne[0] = pierwsza;
        wspolrzedne[1] = druga;
        this.latitiudeUser = wspolrzedne[0];
        this.longitudeUser = wspolrzedne[1];
        return wspolrzedne;
    }
}
