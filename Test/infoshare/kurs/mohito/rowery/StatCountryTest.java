package infoshare.kurs.mohito.rowery;

import infoshareKurs.BikeParsing;
import infoshareKurs.City;
import infoshareKurs.StatCountry;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StatCountryTest {


    @Test
    public void testNazwyMiastaJednoMiastoNaLiscie() {

        StatCountry statCountry=new StatCountry();
        statCountry.setFilePath("testdata/nextbike-liveTestStats1.xml");


        assertEquals("Leipzig",statCountry.getCityStat().get(0));
}
 @Test
    public void testNazwyMiastaTrzyMiastaNaLiscie() {

        StatCountry statCountry=new StatCountry();
        statCountry.setFilePath("testdata/nextbike-liveTestStats2.xml");
     System.out.println(statCountry.getCityStat().get(2));
        assertEquals("Gdansk",statCountry.getCityStat().get(2));
}

@Test
    public void testMiastoBezNazwy() {

        StatCountry statCountry=new StatCountry();
        statCountry.setFilePath("testdata/nextbike-liveTestStats2.xml");

        assertEquals("",statCountry.getCityStat().get(1));
}@Test
    public void kraj() {

        StatCountry statCountry=new StatCountry();
        statCountry.setFilePath("testdata/nextbike-liveTestStats1.xml");

        System.out.println(statCountry.getCountryStat().get(0));
}
}