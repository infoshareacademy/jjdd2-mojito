import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class UserChooseFromMenu {
    protected  void userChooseFromMenu(){
        UserInputReader scanner = new UserInputReader();
        AfterTask aftertask=new AfterTask();
        BikeParsing bikeParsing = new BikeParsing("nextbike-live.xml");
        try {
            bikeParsing.parseData();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
                    NearestPlace nearestPlace = new NearestPlace();
                    nearestPlace.findNearestPlace(geoLocation,bikeParsing);
                    aftertask.aftertask();
                    break;
                case "2":
                    CountryStations countryStations = new CountryStations();
                    countryStations.countryStation();
                    aftertask.aftertask();
                    break;
                case "3":
                    CityStations cityStations = new CityStations();
                    cityStations.cityStation();
                    aftertask.aftertask();
                    break;
                case "4":
                    UserChooseRadius userChooseRadius = new UserChooseRadius();
                    userChooseRadius.Radius();
                    aftertask.aftertask();
                    break;
                case "5":
                    StatCountry.getCountryStat();
                    aftertask.aftertask();
                    break;
                case "6":
                    StatCountry.getCityStat();
                    aftertask.aftertask();
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
