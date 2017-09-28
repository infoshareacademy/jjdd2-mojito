package infoshareKurs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class UserChooseFromMenu {
    private final Logger logger = LogManager.getLogger(UserChooseFromMenu.class);
    protected void userChooseFromMenu(List<City> cityList) {
        UserInputReader scanner = new UserInputReader();
        AfterTask aftertask = new AfterTask();
        logger.debug("Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                "po wykonanej czynnosci");

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
                    logger.debug("Stworzenie geo lokacji uzytkownika");
                    NearestPlaceFinder nearestPlace = new NearestPlaceFinder(cityList);
                    nearestPlace.findNearestPlace(geoLocation);
                    logger.debug("znalezienie najblizszej stacji od uzytkownika");
                    aftertask.aftertask(cityList);
                    logger.debug("Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                            "po wykonanej czynnosci");
                    break;
                case "2":
                    CountryStations countryStations = new CountryStations();
                    countryStations.countryStation(cityList);
                    logger.debug("wypisanie stacji w kraju");
                    aftertask.aftertask(cityList);
                    logger.debug("Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                            "po wykonanej czynnosci");
                    break;
                case "3":
                    CityStations cityStations = new CityStations();
                    cityStations.cityStation(cityList);
                    aftertask.aftertask(cityList);
                    logger.debug("Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                            "po wykonanej czynnosci");
                    break;
                case "4":
                    UserChooseRadius userChooseRadius = new UserChooseRadius();
                    userChooseRadius.Radius(cityList);
                    logger.debug("przekierowanie do submenu userchoose radius");
                    aftertask.aftertask(cityList);
                    logger.debug("Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                            "po wykonanej czynnosci");
                    break;
                case "5":
                    StatCountry statCountry=new StatCountry();
                    statCountry.getCountryStat();
                    aftertask.aftertask(cityList);
                    logger.debug("Implementacja klasy aftertask zajmujaca sie obsluga uzytkownika" +
                            "po wykonanej czynnosci");
                    break;
                case "6":
                    StatCountry statCountry2 =new StatCountry();
                    statCountry2.getCityStat();
                    aftertask.aftertask(cityList);
                    logger.debug("wyswietlenie statystyk o państiwe");
                    break;
                case "7":
                    System.exit(0);
                    logger.debug("Użytkownik wychodzi w aplikacji ");
                    break;

                default:
                    System.out.println("Niepoprawny numer, podaj liczbę od 1-7");
                    logger.warn("Użytkownik wpisal niepoprawny numer wyboru menu.");
            }
        }
    }
}
