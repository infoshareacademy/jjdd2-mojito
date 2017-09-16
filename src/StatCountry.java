import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StatCountry {
    public static void getCityStat (){
        BikeParsing bikeParsing = new BikeParsing("nextbike-live.xml");
        try {
            bikeParsing.parseData();
            System.out.println("Liczba punktów w mieście");
            for(City city : bikeParsing.getCityList()){
                System.out.println(city.getName());
                System.out.println("liczba punktów: " + city.getPlaceList().size());
//                for (Place place: city.getPlaceList()){
//                    System.out.println(place.getName());
//                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void getCountryStat(){
        BikeParsing bikeParsing = new BikeParsing("nextbike-live.xml");
        try {
            bikeParsing.parseData();
            System.out.println("Liczba punktów w kraju");
            Map<String,Integer> countryStats = new HashMap<>();
            for (City city: bikeParsing.getCityList()) {
                if(countryStats.get(city.getCountryName()) == null){
                    countryStats.put(city.getCountryName(), city.getPlaceList().size());
                }else{
                    int currentPointCount = countryStats.get(city.getCountryName());
                    countryStats.put(city.getCountryName(),currentPointCount+city.getPlaceList().size() );
                }
            }

            for(Map.Entry country : countryStats.entrySet()){
                System.out.println(country.getKey());
                System.out.println("LIczba punktów w kraju: " + country.getValue());
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
