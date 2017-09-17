import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class UserChooseRadius {
    protected  void Radius() {
        BikeParsing bikeParsing = new BikeParsing("nextbike-live.xml");
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
        System.out.println("4.Wróc do Menu .");

        int input = 0;
        while (input <= 0) {
            try {
                input = scanner.readlineInteager();
            } catch (NumberFormatException e) {
                System.out.println("Wybierz jedna z opcji Menu wpisujac liczby od 1-4 ");
                continue;
            }catch (NullPointerException e){
                System.out.println("Wybierz jedna z opcji Menu wpisujac liczby od 1-4 ");
            }
            switch (input) {
                case 1:
                    GeoLocation geoLocation5 = new GeoLocation();
                    geoLocation5.geoLocation();
                    NearestPlace nearestPlace = new NearestPlace(bikeParsing.getCityList());
                    nearestPlace.findPlace(geoLocation5,5.0);
                    break;
                case 2:
                    //wyszukanie staci w odleglosci 10km.
                    GeoLocation geoLocation10 = new GeoLocation();
                    geoLocation10.geoLocation();
                    NearestPlace nearestPlace10 = new NearestPlace(bikeParsing.getCityList());
                    nearestPlace10.findPlace(geoLocation10,10.0);
                    break;
                case 3:
                    //wyszukanie staci w odleglosci 15km.
                    GeoLocation geoLocation15 = new GeoLocation();
                    geoLocation15.geoLocation();
                    NearestPlace nearestPlace15 = new NearestPlace(bikeParsing.getCityList());
                    nearestPlace15.findPlace(geoLocation15,15.0);
                    break;
                case 4:
                    UserChooseFromMenu returnMenu = new UserChooseFromMenu();
                    returnMenu.userChooseFromMenu(bikeParsing.getCityList());
                    break;
                default:
                    System.out.println("Wybierz jedna z opcji Menu wpisujac liczby od 1-4 ");

            }
        }
    }
}