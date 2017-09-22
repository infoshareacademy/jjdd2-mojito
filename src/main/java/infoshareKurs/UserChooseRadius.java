package infoshareKurs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class UserChooseRadius {
    private final Logger logger = LogManager.getLogger(UserChooseRadius.class);
    protected void Radius() {
        BikeParsing bikeParsing = new BikeParsing("data/nextbike-live.xml");
        logger.info("Pasrowanie danych z pliku xml");
        AfterTask afterTask = new AfterTask();
        logger.info("implementacja obiektu klasy afterTask");

        
        try {
            bikeParsing.parseData();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        UserInputReader scanner = new UserInputReader();
        logger.info("Implementacja skanera");
        System.out.println("Prosze wybierz promień poszukiwań w km .");
        System.out.println("1.szukaj w odległosci 5 km");
        System.out.println("2.szukaj w odległosci 10 km");
        System.out.println("3.szukaj w odległosci 15 km");
        System.out.println("4.Wróć do Menu .");

        String input = "0";
        while (true) {
            try {
                input = scanner.readlineString();
                logger.info("Wczystanie stringa podanego przez użytkownika");
            } catch (NumberFormatException e) {
                logger.warn("Użytkownik wpisal zły format");
                System.out.println("Wybierz jedną z opcji Menu wpisując liczby od 1-4 ");
                continue;
            } catch (NullPointerException e) {
                logger.warn("Wpisanie null ");
                System.out.println("Wybierz jedną z opcji Menu wpisując liczby od 1-4 ");
            }
            switch (input) {
                case "1":
                    GeoLocation geoLocation5 = new GeoLocation();
                    geoLocation5.geoLocation();
                    logger.info("Stworzenie geo lokacji uzytkownika");
                    NearestPlace nearestPlace = new NearestPlace(bikeParsing.getCityList());
                    logger.info("Zaimplementowanie klasy szukajacej stacji");
                    nearestPlace.findPlace(geoLocation5, 5.0);
                    logger.info("Wiadomosc z danymi o najlizszej stacji badz jej braku");
                    afterTask.aftertask(bikeParsing.getCityList());
                    logger.info("Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                            "po wykonanej czynnosci");
                    break;
                case "2":
                    GeoLocation geoLocation10 = new GeoLocation();
                    geoLocation10.geoLocation();
                    logger.info("Stworzenie geo lokacji uzytkownika");
                    NearestPlace nearestPlace10 = new NearestPlace(bikeParsing.getCityList());
                    logger.info("Zaimplementowanie klasy szukajacej stacji");
                    nearestPlace10.findPlace(geoLocation10, 10.0);
                    logger.info("Wiadomosc z danymi o najlizszej stacji badz jej braku");
                    afterTask.aftertask(bikeParsing.getCityList());
                    logger.info("Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                            "po wykonanej czynnosci");
                    break;
                case "3":
                    GeoLocation geoLocation15 = new GeoLocation();
                    geoLocation15.geoLocation();
                    logger.info("Stworzenie geo lokacji uzytkownika");
                    NearestPlace nearestPlace15 = new NearestPlace(bikeParsing.getCityList());
                    logger.info("Zaimplementowanie klasy szukajacej stacji");
                    nearestPlace15.findPlace(geoLocation15, 15.0);
                    logger.info("Wiadomosc z danymi o najlizszej stacji badz jej braku");
                    afterTask.aftertask(bikeParsing.getCityList());
                    logger.info("Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                            "po wykonanej czynnosci");
                    break;
                case "4":
                    UserChooseFromMenu returnMenu = new UserChooseFromMenu();
                    logger.info("Implementacja Menu");
                    returnMenu.userChooseFromMenu(bikeParsing.getCityList());
                    afterTask.chooseAfterTask();
                    logger.info("Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                            "po wykonanej czynnosci");
                    break;
                default:
                    System.out.println("Wybierz jedną z opcji Menu wpisując liczby od 1-4 ");
                    logger.warn("Cos poszlo nie tak po swichdefault");

            }
        }
    }
}