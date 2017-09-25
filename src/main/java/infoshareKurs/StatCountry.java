package infoshareKurs;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

public class StatCountry {
    public static void getCityStat() {
        BikeParsing bikeParsing = new BikeParsing("testdata/nextbike-live.xml");
        try {
            bikeParsing.parseData();
            Collections.sort(bikeParsing.getCityList(), new Comparator<City>() {
                @Override
                public int compare(City c1, City c2) {
                    if (c1.getPlaceList().size() < c2.getPlaceList().size()) {
                        return 1;
                    } else if (c1.getPlaceList().size() > c2.getPlaceList().size()) {
                        return -1;
                    }
                    return c1.getName().compareTo(c2.getName());
                }
            });
            for (City city : bikeParsing.getCityList()) {
                System.out.println("liczba stacji rowerowych w miescie " + city.getName() + " : " + city.getPlaceList().size());
            }
        } catch (
                ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void getCountryStat() {
        BikeParsing bikeParsing = new BikeParsing("testdata/nextbike-live.xml");
        try {
            bikeParsing.parseData();
            System.out.println("LICZBA STACJI ROWEROWYCH W DANYM KRAJU.");
            SortedMap<String, Integer> countryStats = new TreeMap<>();
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
