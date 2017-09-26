package infoshare.kurs.mohito.rowery;

import org.junit.Test;

import static org.junit.Assert.*;

public class BikeParsingTest {

    @Test
    public void test(){
        BikeParsing bikeParsing = new BikeParsing("data/nextbike-test.xml");
        bikeParsing.parseData();
        assertEquals (7, bikeParsing.getCityList().size());

    }

}