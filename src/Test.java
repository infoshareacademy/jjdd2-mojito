import com.sun.xml.internal.bind.v2.runtime.Coordinator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        //test try catch-
        try { //wyjątek
            BikeParsing bikeParsing = new BikeParsing("nextbike-live.xml");
            bikeParsing.parseData();
            bikeParsing.showData();


            ArrayList<City> cityCordinates = new ArrayList<>();
            for (City city : bikeParsing.getCityList()) {
                cityCordinates.add(new City(city.getLatitude(), city.getLongitude(), city.getName(), city.getCountryName()));

                ArrayList<City> placeCordinates = new ArrayList<>();
                for (Place place : city.getPlaceList()) {
                    placeCordinates.add(new City(place.getLatitiudePlace(), place.getLongitudePlace(), city.getName(), city.getCountryName()));
//
                }


            }
            GeoLocation userLocation = new GeoLocation();
            DistanceMath math1 = new DistanceMath();


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}






//} catch(ParserConfigurationException e){
//                e.printStackTrace();
//                //wypisuje gdzie był wyjatek} catch(SAXException e){
//                e.printStackTrace();
//            } catch(IOException e){
//                e.printStackTrace();