package infoshareKurs;

import infoshareKurs.DistanceMath;
import infoshareKurs.GeoLocation;
import infoshareKurs.Place;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class PlaceCordi {

    public String DistanceMath (Place place){


        final Logger logger = LogManager.getLogger(infoshareKurs.DistanceMath.class);
            double k = place.getLatitiudePlace();
            double j = place.getLongitudePlace();

            String placeCord = String.valueOf(k)+","+String.valueOf(j);


            return placeCord;
        }
    }

