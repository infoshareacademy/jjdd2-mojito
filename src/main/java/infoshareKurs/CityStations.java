package infoshareKurs;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CityStations {
    private final Logger logger = LogManager.getLogger(CityStations.class);

    protected void cityStation() {
        final BikeParsing bikeParsing = new BikeParsing("data/nextbike-live.xml");
        try {
            bikeParsing.parseData();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error("błędu parsowania pliku xml");
        }
        System.out.println("Wpisz nazwę interesującego Cię miasta.");
        boolean done = false;
        while (!done) {
            UserInputReader inputCity = new UserInputReader();
            String inputdata = inputCity.readlineString();

            int i = 0;
            System.out.format("Stacje rowerowe znajdujące sie w %s :\n", inputdata);
            for (City city : bikeParsing.getCityList()) {
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

