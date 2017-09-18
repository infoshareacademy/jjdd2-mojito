package infoshare.kurs.mohito.rowery;

public class GeoLocation {

    protected double latitiudeUser;

    protected double longitudeUser;

    public double getLatitiudeUser() {
        return latitiudeUser;
    }

    public double getLongitudeUser() {
        return longitudeUser;
    }

    protected double[] geoLocation() {
        double[] wspolrzedne = new double[2];
        System.out.println("Prosze podaj swoje wspolrzedne geograficzne.");

        boolean done = false;
        while (!done) {
            try {
                System.out.println("podaj pierwsza wspolrzedna ");
                String pierwszastring = new UserInputReader().readlineString();
                pierwszastring = pierwszastring.replace(",", ".");
                double pierwsza = Double.parseDouble(pierwszastring);
                pierwsza = Math.abs(pierwsza);
                wspolrzedne[0] = pierwsza;
                this.latitiudeUser = wspolrzedne[0];
                this.longitudeUser = wspolrzedne[1];
                done = true;
            } catch (NumberFormatException e) {
                System.out.println("niepoprawny format, podaj pierwsza wspolrzedna ponownie");

            }
        }
        done = false;

        while (!done) {
            try {

                System.out.println("podaj druga wspolrzedna ");
                String drugastring = new UserInputReader().readlineString();
                drugastring = drugastring.replace(",", ".");
                double druga = Double.parseDouble(drugastring);//parsowanie z string na double
                druga = Math.abs(druga);
                wspolrzedne[1] = druga;
                this.longitudeUser = wspolrzedne[1];
                done = true;

            } catch (NumberFormatException e) {
                System.out.println("niepoprawny format, podaj druga wspolrzedna ponownie");

            }

        }

        return wspolrzedne;


    }
}
