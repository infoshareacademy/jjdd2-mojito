package infoshareKurs;

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
        System.out.println("Prosze wybierz promień poszukiwań w km .");
        System.out.println("1.szukaj w odległosci 5 km");
        System.out.println("2.szukaj w odległosci 10 km");
        System.out.println("3.szukaj w odległosci 15 km");
        System.out.println("4.Wróć do Menu .");

        String input = "0";
        while (true) {
            try {
                input = scanner.readlineString();
            } catch (NumberFormatException e) {
                System.out.println("Wybierz jedną z opcji Menu wpisując liczby od 1-4 ");
                continue;
            } catch (NullPointerException e) {
                System.out.println("Wybierz jedną z opcji Menu wpisując liczby od 1-4 ");
            }
            switch (input) {
                case "1":
                    GeoLocation geoLocation5 = new GeoLocation();
                    geoLocation5.geoLocation();
                    NearestPlace nearestPlace = new NearestPlace(bikeParsing.getCityList());
                    nearestPlace.findPlace(geoLocation5, 5.0);
                    afterTask.aftertask(bikeParsing.getCityList());
                    break;
                case "2":
                    GeoLocation geoLocation10 = new GeoLocation();
                    geoLocation10.geoLocation();
                    NearestPlace nearestPlace10 = new NearestPlace(bikeParsing.getCityList());
                    nearestPlace10.findPlace(geoLocation10, 10.0);
                    afterTask.aftertask(bikeParsing.getCityList());
                    break;
                case "3":
                    GeoLocation geoLocation15 = new GeoLocation();
                    geoLocation15.geoLocation();
                    NearestPlace nearestPlace15 = new NearestPlace(bikeParsing.getCityList());
                    nearestPlace15.findPlace(geoLocation15, 15.0);
                    afterTask.aftertask(bikeParsing.getCityList());
                    break;
                case "4":
                    UserChooseFromMenu returnMenu = new UserChooseFromMenu();
                    returnMenu.userChooseFromMenu(bikeParsing.getCityList());
                    afterTask.chooseAfterTask();
                    break;
                default:
                    System.out.println("Wybierz jedną z opcji Menu wpisując liczby od 1-4 ");

            }
        }
    }
}