package infoshare.kurs.mohito.rowery;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class UserChooseRadius {
    protected void Radius() {
        BikeParsing bikeParsing = new BikeParsing("nextbike-live.xml");
        AfterTask afterTask = new AfterTask();

        try {
            bikeParsing.parseData();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        UserInputReader scanner = new UserInputReader();
        System.out.println("Prosze wybierz promien poszukiwan w km .");
        System.out.println("1.szukaj w odleg1osci 5 km");
        System.out.println("2.szukaj w odleg1osci 10 km");
        System.out.println("3.szukaj w odleg1osci 15 km");
        System.out.println("4.Wróc do infoshare.kurs.mohito.rowery.Menu .");

        String input = "0";
        while (true) {
            try {
                input = scanner.readlineString();
            } catch (NumberFormatException e) {
                System.out.println("Wybierz jedna z opcji infoshare.kurs.mohito.rowery.Menu wpisujac liczby od 1-4 ");
                continue;
            } catch (NullPointerException e) {
                System.out.println("Wybierz jedna z opcji infoshare.kurs.mohito.rowery.Menu wpisujac liczby od 1-4 ");
            }
            switch (input) {
                case "1":
                    GeoLocation geoLocation5 = new GeoLocation();
                    geoLocation5.geoLocation();
                    NearestPlace nearestPlace = new NearestPlace();
                    nearestPlace.findPlace(geoLocation5, bikeParsing, 5.0);
                    afterTask.aftertask();
                    break;
                case "2":
                    //wyszukanie staci w odleglosci 10km.
                    GeoLocation geoLocation10 = new GeoLocation();
                    geoLocation10.geoLocation();
                    NearestPlace nearestPlace10 = new NearestPlace();
                    nearestPlace10.findPlace(geoLocation10, bikeParsing, 10.0);
                    afterTask.aftertask();
                    break;
                case "3":
                    //wyszukanie staci w odleglosci 15km.
                    GeoLocation geoLocation15 = new GeoLocation();
                    geoLocation15.geoLocation();
                    NearestPlace nearestPlace15 = new NearestPlace();
                    nearestPlace15.findPlace(geoLocation15, bikeParsing, 15.0);
                    afterTask.aftertask();
                    break;
                case "4":
                    UserChooseFromMenu returnMenu = new UserChooseFromMenu();
                    returnMenu.userChooseFromMenu();
                    afterTask.chooseAfterTask();
                    break;
                default:
                    System.out.println("Wybierz jedna z opcji infoshare.kurs.mohito.rowery.Menu wpisujac liczby od 1-4 ");

            }
        }
    }
}