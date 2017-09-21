package infoshareKurs;

import java.util.List;

public class UserChooseFromMenu {
    protected void userChooseFromMenu(List<City> cityList) {
        UserInputReader scanner = new UserInputReader();
        AfterTask aftertask = new AfterTask();

        String input = "0";
        while (true) {
            try {
                input = (scanner.readlineString());
            } catch (NumberFormatException e) {
                System.out.println("Wybierz jedną z opcji Menu wpisując liczby od 1-7 ");
                continue;
            }
            switch (input) {
                case "1":
                    GeoLocation geoLocation = new GeoLocation();
                    geoLocation.geoLocation();
                    NearestPlace nearestPlace = new NearestPlace(cityList);
                    nearestPlace.findNearestPlace(geoLocation);
                    aftertask.aftertask(cityList);
                    break;
                case "2":
                    CountryStations countryStations = new CountryStations();
                    countryStations.countryStation();
                    aftertask.aftertask(cityList);
                    break;
                case "3":
                    CityStations cityStations = new CityStations();
                    cityStations.cityStation();
                    aftertask.aftertask(cityList);
                    break;
                case "4":
                    UserChooseRadius userChooseRadius = new UserChooseRadius();
                    userChooseRadius.Radius();
                    aftertask.aftertask(cityList);
                    break;
                case "5":
                    StatCountry.getCountryStat();
                    aftertask.aftertask(cityList);
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
            }
        }
    }
}
