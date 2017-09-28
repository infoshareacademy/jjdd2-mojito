package infoshareKurs;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class CountryStations {
    private final Logger logger = LogManager.getLogger(CountryStations.class);
    protected void countryStation(List<City> cityList) {

        System.out.println("Wpisz nazwę interesującego Cię państwa.");
        boolean done = false;
        while (!done) {
            UserInputReader inputcountry = new UserInputReader();
            String inputdata = inputcountry.readlineString();

            int i = 0;
            System.out.format("Stacje rowerowe znajdujące sie w %s :\n", inputdata);
            for (City city : cityList) {
                if (city.getCountryName().equals(inputdata)) {
                    i++;
                    for (Place place : city.getPlaceList()) {
                        System.out.println(place.getName() +"  /  "+city.getName());
                        logger.debug("wypisanie stacji rowerowych znajdujacych sie danym kraju");
                    }
                }
                done = true;
            }
            if (i == 0) {
                System.out.println("Nie znaleziono państwa w bazie, wprowadź nazwę ponownie.");
                logger.info("nie znaleziono kraju w bazie danych ");
            }
        }
    }
}

