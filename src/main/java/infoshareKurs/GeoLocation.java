package infoshareKurs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GeoLocation {
    private final Logger logger = LogManager.getLogger(GeoLocation.class);

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
        System.out.println("Proszę podaj swoje współrzędne geograficzne.");

        boolean done = false;
        while (!done) {
            try {
                System.out.println("Podaj szerokość geograficzną \n wzór XXXX.XXXX");
                String pierwszaString = new UserInputReader().readlineString();
                pierwszaString = pierwszaString.replace(",", ".");
                double pierwsza = Double.parseDouble(pierwszaString);
                logger.info("Uzytkownik podaje swoja szerokosc geograficzna");
                pierwsza = Math.abs(pierwsza);
                wspolrzedne[0] = pierwsza;
                this.latitiudeUser = wspolrzedne[0];
                this.longitudeUser = wspolrzedne[1];
                done = true;
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawny format, podaj szerokość geograficzną ponownie");
                logger.warn("Użytkownik wpisal niepoprawny format podczas podawawania szerokosc geograficznej");

            }
        }
        done = false;

        while (!done) {
            try {

                System.out.println("Podaj długość geograficzną \n wzór XXXX.XXXX");
                String drugaString = new UserInputReader().readlineString();
                drugaString = drugaString.replace(",", ".");
                logger.info("Uzytkownik podaje swoja długość geograficzna");
                double druga = Double.parseDouble(drugaString);//parsowanie z string na double
                druga = Math.abs(druga);
                wspolrzedne[1] = druga;
                this.longitudeUser = wspolrzedne[1];
                done = true;

            } catch (NumberFormatException e) {
                logger.warn("Użytkownik wpisal niepoprawny format podczas podawawania długosci geograficznej");
                System.out.println("Niepoprawny format, podaj długość geograficzną ponownie");

            }
        }
        return wspolrzedne;
    }
}
