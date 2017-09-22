package infoshare.kurs.mohito.rowery;
import infoshareKurs.DistanceMath;
import infoshareKurs.GeoLocation;
import infoshareKurs.Place;
import org.junit.Test;

import static org.junit.Assert.*;

public class DistanceMathTest {


    @Test
    public void everyValueEquals0() {

        Place place=new Place("",0,0);

        GeoLocation geoLocation=new GeoLocation();
        geoLocation.setLatitiudeUser(0);
        geoLocation.setLongitudeUser(0);


        DistanceMath distanceMath = new DistanceMath();

        double distance = distanceMath.countDistance(place,geoLocation);

        assertEquals(0,distance,0);

    }
    @Test
    public void placeValuesPositive() {

        Place place=new Place("",20,20);

        GeoLocation geoLocation=new GeoLocation();
        geoLocation.setLongitudeUser(0);
        geoLocation.setLatitiudeUser(0);

        DistanceMath distanceMath = new DistanceMath();

        double distance = distanceMath.countDistance(place,geoLocation);

        double x=distance;

        distance = ((int) ((x * 0.01) + ((x < 0.0) ? -0.5 : 0.5))) / 0.01;

        double delta =0;
        assertEquals(3100,distance,delta);

    }


    @Test
    public void placeValuesNegative() {

        Place place=new Place("",-20,-20);

        GeoLocation geoLocation=new GeoLocation();
        geoLocation.setLatitiudeUser(0);
        geoLocation.setLongitudeUser(0);


        DistanceMath distanceMath = new DistanceMath();

        double distance = distanceMath.countDistance(place,geoLocation);

        double x=distance;

        distance = ((int) ((x * 0.01) + ((x < 0.0) ? -0.5 : 0.5))) / 0.01;

        double delta =0;

        assertEquals(3100,distance,delta);

    }

    @Test
    public void placeLatitiudePositiveLongtitudeNegative() {

        Place place=new Place("",15,-20);

        GeoLocation geoLocation=new GeoLocation();
        geoLocation.setLatitiudeUser(0);
        geoLocation.setLongitudeUser(0);


        DistanceMath distanceMath = new DistanceMath();

        double distance = distanceMath.countDistance(place,geoLocation);

        double x=distance;

        distance = ((int)((x * 0.01) + ((x < 0.0) ? -0.5 : 0.5))) / 0.01;

        double delta =0;

        assertEquals(2800,distance,delta);

    }
    @Test
    public void placeLatitiudeNegativeLongtitudePositive() {

        Place place=new Place("",-20,15);

        GeoLocation geoLocation=new GeoLocation();
        geoLocation.setLatitiudeUser(0);
        geoLocation.setLongitudeUser(0);


        DistanceMath distanceMath = new DistanceMath();

        double distance = distanceMath.countDistance(place,geoLocation);

        double x=distance;

        distance = ((int)((x * 0.01) + ((x < 0.0) ? -0.5 : 0.5))) / 0.01;

        double delta =0;
        assertEquals(2800,distance,delta);

    }

    @Test
    public void everyValuePositive() {

        Place place=new Place("",10,10);

        GeoLocation geoLocation=new GeoLocation();
        geoLocation.setLatitiudeUser(20);
        geoLocation.setLongitudeUser(20);


        DistanceMath distanceMath = new DistanceMath();

        double distance = distanceMath.countDistance(place,geoLocation);

        double x=distance;

        distance = ((int)((x * 0.01) + ((x < 0.0) ? -0.5 : 0.5))) / 0.01;

        double delta =0;
        assertEquals(1500,distance,delta);

    }

    @Test
    public void everyValueNegative() {

        Place place=new Place("",-10,-10);

        GeoLocation geoLocation=new GeoLocation();
        geoLocation.setLatitiudeUser(-20);
        geoLocation.setLongitudeUser(-20);

        DistanceMath distanceMath = new DistanceMath();

        double distance = distanceMath.countDistance(place,geoLocation);

        double x=distance;

        distance = ((int)((x * 0.01) + ((x < 0.0) ? -0.5 : 0.5))) / 0.01;

        double delta =0;
        assertEquals(1500,distance,delta);
    }
//sprawdzić≤ bo jest jakiś błąd
    @Test
    public void geolocationNegativePlacePositive() {

        Place place=new Place("",10,10);

        GeoLocation geoLocation=new GeoLocation();
        geoLocation.setLatitiudeUser(-20);
        geoLocation.setLongitudeUser(-20);

        DistanceMath distanceMath = new DistanceMath();

        double distance = distanceMath.countDistance(place,geoLocation);

        double x=distance;

        distance = ((int)((x * 0.01) + ((x < 0.0) ? -0.5 : 0.5))) / 0.01;
        System.out.println(distance);
        double delta =0;
        assertEquals(4600,distance,delta);
    }


}
