package infoshareKurs;

public class GeoLocation {

    protected double latitiudeUser;

    protected double longitudeUser;

    public double getLatitiudeUser() {
        return latitiudeUser;
    }

    public void setLatitiudeUser(double latitiudeUser) {
        this.latitiudeUser = latitiudeUser;
    }

    public double getLongitudeUser() {
        return longitudeUser;
    }

    public void setLongitudeUser(double longitudeUser) {
        this.longitudeUser = longitudeUser;
    }

    protected double[] geoLocation() {
        double[] wspolrzedne = new double[2];
        System.out.println("Prosze podaj swoje wspolrzedne geograficzne.");

        boolean done = false;
        while (!done) {
            try {
                System.out.println("podaj pierwsza wspolrzedna Geograficzna \n wzór XXXX.XXXX");
                String pierwszastring = new UserInputReader().readlineString();
                pierwszastring = pierwszastring.replace(",", ".");
                double pierwsza = Double.parseDouble(pierwszastring);
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

                System.out.println("podaj druga wspolrzedna Geograficzna \n wzór XXXX.XXXX");
                String drugastring = new UserInputReader().readlineString();
                drugastring = drugastring.replace(",", ".");
                double druga = Double.parseDouble(drugastring);//parsowanie z string na double
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
