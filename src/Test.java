import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        //test try catch-
        try { //wyjątek
            BikeParsing bikeParsing = new BikeParsing("nextbike-live.xml");
            bikeParsing.parseData();
            bikeParsing.showData();


            ArrayList<Cordinates> cordinates = new ArrayList<>();
            for (City city:bikeParsing.getCityList()) {
                cordinates.add(new Cordinates(city.getLatitude(), city.getLongitude(),city.getName()));

                for (Place place:city.getPlaceList()) {
                    cordinates.add(new Cordinates());
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            //wypisuje gdzie był wyjatek
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
