package infoshare.kurs.mohito.rowery;
import infoshareKurs.DistanceMath;
import infoshareKurs.GeoLocation;
import infoshareKurs.Place;
import org.junit.Test;

import static org.junit.Assert.*;

public class DistanceMathTest {


    @Test
    public void test1() {

        Place place=new Place("",0,0);

        GeoLocation geoLocation=new GeoLocation();

        DistanceMath distanceMath = new DistanceMath();

        double distance = distanceMath.countDistance(place,geoLocation);

        assertEquals(0,distance,0);

    }
    @Test
    public void test2() {

        Place place=new Place("",20,20);

        GeoLocation geoLocation=new GeoLocation();

        DistanceMath distanceMath = new DistanceMath();

        double distance = distanceMath.countDistance(place,geoLocation);

        double x=distance;

        distance = ((int) ((x * 0.01) + ((x < 0.0) ? -0.5 : 0.5))) / 0.01;

        double delta =0;
        assertEquals(3100,distance,delta);

    }


    @Test
    public void test3() {

        Place place=new Place("",-20,-20);

        GeoLocation geoLocation=new GeoLocation();

        DistanceMath distanceMath = new DistanceMath();

        double distance = distanceMath.countDistance(place,geoLocation);

        double x=distance;

        distance = ((int) ((x * 0.01) + ((x < 0.0) ? -0.5 : 0.5))) / 0.01;
        System.out.println(distance);

        System.out.println(x);

        double delta =0;

        assertEquals(3100,distance,delta);

    }

    @Test
    public void test4() {

        Place place=new Place("",15,-20);

        GeoLocation geoLocation=new GeoLocation();

        DistanceMath distanceMath = new DistanceMath();

        double distance = distanceMath.countDistance(place,geoLocation);

        double x=distance;

        distance = ((int)((x * 0.01) + ((x < 0.0) ? -0.5 : 0.5))) / 0.01;

        double delta =0;

        assertEquals(2800,distance,delta);

    }
    @Test
    public void test5() {

        Place place=new Place("",-20,15);

        GeoLocation geoLocation=new GeoLocation();

        DistanceMath distanceMath = new DistanceMath();

        double distance = distanceMath.countDistance(place,geoLocation);

        double x=distance;

        distance = ((int)((x * 0.01) + ((x < 0.0) ? -0.5 : 0.5))) / 0.01;

        double delta =0;
        assertEquals(2800,distance,delta);

    }


}
