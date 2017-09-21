package infoshareKurs;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.logging.Logger;

public class CountryStations {
    protected final Logger logger = Logger.getLogger(getClass().getName());
    protected void countryStation() {
        BikeParsing bikeParsing = new BikeParsing("nextbike-live.xml");
        try {
            bikeParsing.parseData();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("Wpisz nazwę interesującego Cię państwa.");
        boolean done = false;
        while (!done) {
            UserInputReader inputcountry = new UserInputReader();
            String inputdata = inputcountry.readlineString();

            int i = 0;
            System.out.format("Stacje rowerowe znajdujące sie w %s :\n", inputdata);
            for (City city : bikeParsing.getCityList()) {
                if (city.getCountryName().equals(inputdata)) {
                    i++;
                    for (Place place : city.getPlaceList()) {
                        System.out.println(place.getName() +"  /  "+city.getName());
                    }
                }
                done = true;
            }
            if (i == 0) {
                System.out.println("Nie znaleziono państwa w bazie, wprowadź nazwę ponownie.");
            }
        }
    }
}
