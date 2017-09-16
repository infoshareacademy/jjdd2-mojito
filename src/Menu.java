import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {


    public static void main(String[] args) {
        try {
            BikeParsing bikeParsing = new BikeParsing("nextbike-live.xml");
            bikeParsing.parseData();
//            bikeParsing.showData();
            MenuText menuText = new MenuText();
            menuText.Text();
            UserChooseFromMenu choose = new UserChooseFromMenu();
            choose.userChooseFromMenu();


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

