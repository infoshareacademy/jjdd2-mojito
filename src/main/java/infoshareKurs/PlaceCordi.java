package infoshareKurs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlaceCordi {

    public String DistanceMath (Place place){


        final Logger logger = LogManager.getLogger(infoshareKurs.DistanceMath.class);
            double k = place.getLatitudePlace();
            double j = place.getLongitudePlace();

            String placeCord = String.valueOf(k)+","+String.valueOf(j);


            return placeCord;
        }
    }

