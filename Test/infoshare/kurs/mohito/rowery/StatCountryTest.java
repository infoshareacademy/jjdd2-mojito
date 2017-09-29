package infoshare.kurs.mohito.rowery;

import infoshareKurs.BikeParsing;
import infoshareKurs.City;
import infoshareKurs.FilePath;
import infoshareKurs.StatCountry;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StatCountryTest {

    FilePath  filePath=new FilePath();
    @Test
    public void testNazwyMiastaJednoMiastoNaLiscie() {

        BikeParsing bikeParsing = new BikeParsing("testdata/nextbike-liveTestStats1.xml");

        StatCountry statCountry=new StatCountry(bikeParsing);
        filePath.setFilepath();



        assertEquals("Leipzig",statCountry.getCityStat().get(0));
}
 @Test
    public void testNazwyMiastaTrzyMiastaNaLiscie() {

        StatCountry statCountry=new StatCountry();
     filePath.setFilepath("testdata/nextbike-liveTestStats2.xml");
     System.out.println(statCountry.getCityStat().get(2));
        assertEquals("Gdansk",statCountry.getCityStat().get(2));
}

@Test
    public void testMiastoBezNazwy() {

        StatCountry statCountry=new StatCountry();
    filePath.setFilepath("testdata/nextbike-liveTestStats2.xml");


        assertEquals("",statCountry.getCityStat().get(1));
}@Test
    public void kraj() {

        StatCountry statCountry=new StatCountry();
        filePath.setFilepath("testdata/nextbike-liveTestStats1.xml");

        System.out.println(statCountry.getCountryStat().get(0));
}
}