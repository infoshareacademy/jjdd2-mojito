import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class UserChooseFromMenu {
    protected  void userChooseFromMenu(List<City> cityList){
        UserInputReader scanner = new UserInputReader();
        /*BikeParsing bikeParsing = new BikeParsing("nextbike-live.xml");
        try {
            bikeParsing.parseData();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        String input = "0";
        while (true) {
            try {
                input =(scanner.readlineString());
            } catch (NumberFormatException e) {
                System.out.println("Wybierz jedna z opcji Menu wpisujac liczby od 1-7 ");
                continue;
            }
            switch (input) {
                case "1":
                    GeoLocation geoLocation = new GeoLocation();
                    geoLocation.geoLocation();
                    NearestPlace nearestPlace = new NearestPlace(cityList);
                    nearestPlace.findNearestPlace(geoLocation);
                    break;
                case "2":
                    CountryStations countryStations = new CountryStations();
                    countryStations.countryStation();
                    break;
                case "3":
                    CityStations cityStations = new CityStations();
                    cityStations.cityStation();
                    break;
                case "4":
                    UserChooseRadius userChooseRadius = new UserChooseRadius();
                    userChooseRadius.Radius();
                    break;
                case "5":
                    StatCountry.getCountryStat();
                    break;
                case "6":
                    StatCountry.getCityStat();
                    break;
                case "7":
                    System.exit(0);
                    break;

                default:
                    System.out.println("niepoprawny numer podaj liczbe od 1-7");
            }
        }
    }
}
