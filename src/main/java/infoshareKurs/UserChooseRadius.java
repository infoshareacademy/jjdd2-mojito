package infoshareKurs;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserChooseRadius {
    protected final Logger logger = Logger.getLogger(getClass().getName());
    protected void Radius() {
        BikeParsing bikeParsing = new BikeParsing("nextbike-live.xml");
        logger.log(Level.INFO,"Pasrowanie danych z pliku xml");
        AfterTask afterTask = new AfterTask();
        logger.log(Level.INFO,"implementacja obiektu klasy afterTask");

        try {
            bikeParsing.parseData();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        UserInputReader scanner = new UserInputReader();
        logger.log(Level.INFO,"Implementacja skanera");
        System.out.println("Prosze wybierz promień poszukiwań w km .");
        System.out.println("1.szukaj w odległosci 5 km");
        System.out.println("2.szukaj w odległosci 10 km");
        System.out.println("3.szukaj w odległosci 15 km");
        System.out.println("4.Wróć do Menu .");

        String input = "0";
        while (true) {
            try {
                input = scanner.readlineString();
                logger.log(Level.INFO,"Wczystanie stringa podanego przez użytkownika");
            } catch (NumberFormatException e) {
                logger.log(Level.WARNING,"Użytkownik wpisal zły format");
                System.out.println("Wybierz jedną z opcji Menu wpisując liczby od 1-4 ");
                continue;
            } catch (NullPointerException e) {
                logger.log(Level.WARNING,"Wpisanie null ");
                System.out.println("Wybierz jedną z opcji Menu wpisując liczby od 1-4 ");
            }
            switch (input) {
                case "1":
                    GeoLocation geoLocation5 = new GeoLocation();
                    geoLocation5.geoLocation();
                    logger.log(Level.INFO,"Stworzenie geo lokacji uzytkownika");
                    NearestPlace nearestPlace = new NearestPlace(bikeParsing.getCityList());
                    logger.log(Level.INFO,"Zaimplementowanie klasy szukajacej stacji");
                    nearestPlace.findPlace(geoLocation5, 5.0);
                    logger.log(Level.INFO,"Wiadomosc z danymi o najlizszej stacji badz jej braku");
                    afterTask.aftertask(bikeParsing.getCityList());
                    logger.log(Level.INFO,"Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                            "po wykonanej czynnosci");
                    break;
                case "2":
                    GeoLocation geoLocation10 = new GeoLocation();
                    geoLocation10.geoLocation();
                    logger.log(Level.INFO,"Stworzenie geo lokacji uzytkownika");
                    NearestPlace nearestPlace10 = new NearestPlace(bikeParsing.getCityList());
                    logger.log(Level.INFO,"Zaimplementowanie klasy szukajacej stacji");
                    nearestPlace10.findPlace(geoLocation10, 10.0);
                    logger.log(Level.INFO,"Wiadomosc z danymi o najlizszej stacji badz jej braku");
                    afterTask.aftertask(bikeParsing.getCityList());
                    logger.log(Level.INFO,"Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                            "po wykonanej czynnosci");
                    break;
                case "3":
                    GeoLocation geoLocation15 = new GeoLocation();
                    geoLocation15.geoLocation();
                    logger.log(Level.INFO,"Stworzenie geo lokacji uzytkownika");
                    NearestPlace nearestPlace15 = new NearestPlace(bikeParsing.getCityList());
                    logger.log(Level.INFO,"Zaimplementowanie klasy szukajacej stacji");
                    nearestPlace15.findPlace(geoLocation15, 15.0);
                    logger.log(Level.INFO,"Wiadomosc z danymi o najlizszej stacji badz jej braku");
                    afterTask.aftertask(bikeParsing.getCityList());
                    logger.log(Level.INFO,"Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                            "po wykonanej czynnosci");
                    break;
                case "4":
                    UserChooseFromMenu returnMenu = new UserChooseFromMenu();
                    logger.log(Level.INFO,"Implementacja Menu");
                    returnMenu.userChooseFromMenu(bikeParsing.getCityList());
                    afterTask.chooseAfterTask();
                    logger.log(Level.INFO,"Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                            "po wykonanej czynnosci");
                    break;
                default:
                    System.out.println("Wybierz jedną z opcji Menu wpisując liczby od 1-4 ");
                    logger.log(Level.WARNING,"Cos poszlo nie tak po swichdefault");

            }
        }
    }
}