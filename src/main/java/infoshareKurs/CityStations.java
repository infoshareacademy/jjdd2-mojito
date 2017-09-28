package infoshareKurs;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CityStations {
    private final Logger logger = LogManager.getLogger(CityStations.class);

    protected void cityStation(List<City> cityList) {

        System.out.println("Wpisz nazwę interesującego Cię miasta.");
        boolean done = false;
        while (!done) {
            UserInputReader inputCity = new UserInputReader();
            String inputdata = inputCity.readlineString();

            int i = 0;
            System.out.format("Stacje rowerowe znajdujące sie w %s :\n", inputdata);
            for (City city : cityList) {
                if (city.getName().equals(inputdata)) {
                    i++;
                    for (Place place : city.getPlaceList()) {
                        System.out.println(place.getName());
                        logger.info("wypisanie stacji znajdujacych sie w danym miescie");
                    }
                    done = true;
                }

            }
            if (i == 0) {
                System.out.println("Nie znaleziono miasta w bazie, wprowadź nazwę miasta ponownie.");
            }
        }
    }
}

