package infoshare.kurs.mohito.rowery;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StatCountry {
    protected static void getCityStat() {
        BikeParsing bikeParsing = new BikeParsing("nextbike-live.xml");
        try {
            bikeParsing.parseData();
            for (City city : bikeParsing.getCityList()) {
                System.out.println("liczba stacji rowerowych w miescie " + city.getName() +" : "+ city.getPlaceList().size());
            }
        } catch (
                ParserConfigurationException | SAXException | IOException e)
        {
            e.printStackTrace();
        }
    }

    protected static void getCountryStat() {
        BikeParsing bikeParsing = new BikeParsing("nextbike-live.xml");
        try {
            bikeParsing.parseData();
            System.out.println("LICZBA STACJI ROWEROWYCH W DANYM KRAJU.");
            Map<String, Integer> countryStats = new HashMap<>();
            for (City city : bikeParsing.getCityList()) {
                if (countryStats.get(city.getCountryName()) == null) {
                    countryStats.put(city.getCountryName(), city.getPlaceList().size());
                } else {
                    int currentPointCount = countryStats.get(city.getCountryName());
                    countryStats.put(city.getCountryName(), currentPointCount + city.getPlaceList().size());
                }
            }

            for (Map.Entry country : countryStats.entrySet()) {
                System.out.println("Liczba stacji rowerowych w " + country.getKey() + ": " + country.getValue());
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }
}
