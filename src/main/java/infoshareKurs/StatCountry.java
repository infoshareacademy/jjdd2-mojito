package infoshareKurs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;


public class StatCountry {
    final static Logger logger = LogManager.getLogger();
    public Map<String, Integer> getCityStat() {

        Map<String, Integer> cityStats = new TreeMap<>();

        Configuration config = ConfigurationLoader.getConfiguration();

        logger.debug("Stworzenie statystyk państwa");

        BikeParsing bikeParsing = new BikeParsing(config.getBikeDataPath());
        logger.error("blad parsowania pliku xml");
//    private TestLogger logger;


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
                cityStats.put(city.getName(), city.getPlaceList().size());

            }
        } catch (
                ParserConfigurationException | SAXException | IOException e) {
            logger.warn("bład parsowania pliku");
        }
        return cityStats;
    }

    public Map<String, Integer> getCountryStat() {

        Configuration config = ConfigurationLoader.getConfiguration();

        BikeParsing bikeParsing = new BikeParsing(config.getBikeDataPath());

        SortedMap<String, Integer> countryStats = new TreeMap<>();
        try {
            bikeParsing.parseData();
            System.out.println("LICZBA STACJI ROWEROWYCH W DANYM PAŃSTWIE.");

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
        return countryStats;

    }
}
