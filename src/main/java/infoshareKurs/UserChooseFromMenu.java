package infoshareKurs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserChooseFromMenu {
    private final Logger logger = LogManager.getLogger();
    protected void userChooseFromMenu(List<City> cityList) {
        UserInputReader scanner = new UserInputReader();
        AfterTask aftertask = new AfterTask();

        String input = "0";
        while (true) {
            try {
                input = (scanner.readlineString());
            } catch (NumberFormatException e) {
                System.out.println("Wybierz jedną z opcji Menu wpisując liczby od 1-7 ");
                logger.warn("Użytkownik wpisal niepoprawny numer wyboru menu.");
                continue;
            }
            switch (input) {
                case "1":
                    GeoLocation geoLocation = new GeoLocation();
                    geoLocation.geoLocation();
                    logger.info("Stworzenie geo lokacji uzytkownika");
                    NearestPlace nearestPlace = new NearestPlace(cityList);
                    nearestPlace.findNearestPlace(geoLocation);
                    logger.info("znalezienie najblizszej stacji od uzytkownika");
                    aftertask.aftertask(cityList);
                    logger.info("Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                            "po wykonanej czynnosci");
                    break;
                case "2":
                    CountryStations countryStations = new CountryStations();
                    countryStations.countryStation();
                    logger.info("wypisanie stacji w kraju");
                    aftertask.aftertask(cityList);
                    logger.info("Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                            "po wykonanej czynnosci");
                    break;
                case "3":
                    CityStations cityStations = new CityStations();
                    cityStations.cityStation();
                    aftertask.aftertask(cityList);
                    logger.info("Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                            "po wykonanej czynnosci");
                    break;
                case "4":
                    UserChooseRadius userChooseRadius = new UserChooseRadius();
                    userChooseRadius.Radius();
                    logger.info("przekierowanie do submenu userchoose radius");
                    aftertask.aftertask(cityList);
                    logger.info("Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                            "po wykonanej czynnosci");
                    break;
                case "5":
                    StatCountry.getCountryStat();
                    aftertask.aftertask(cityList);
                    logger.info("Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                            "po wykonanej czynnosci");
                    break;
                case "6":
                    StatCountry.getCityStat();
                    aftertask.aftertask(cityList);
                    break;
                case "7":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Niepoprawny numer, podaj liczbę od 1-7");
                    logger.warn("Użytkownik wpisal niepoprawny numer wyboru menu.");
            }
        }
    }
}
