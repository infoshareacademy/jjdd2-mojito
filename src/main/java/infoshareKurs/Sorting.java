package infoshareKurs;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class Sorting {

     public sortByAlphabet(){
         return;
     }

     public sortByQuantity(){

     }


    public Map<String, Integer> getCityStat() {
        Configuration config = ConfigurationLoader.getConfiguration();

        BikeParsing bikeParsing = new BikeParsing(config.getBikeDataPath());

        Collections.sort(bikeParsing.getCityList(), new Comparator<City>() {

            public int compare(City c1, City c2) {
                if (c1.getPlaceList().size() < c2.getPlaceList().size()) {
                    return 1;
                } else if (c1.getPlaceList().size() > c2.getPlaceList().size()) {
                    return -1;
                }
                return c1.getName().compareTo(c2.getName());
            }
        });
    }
}
