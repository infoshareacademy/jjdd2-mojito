package infoshare.kurs.mohito.rowery;

import infoshareKurs.BikeParsing;
import infoshareKurs.City;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BikeParsingTest {

    @Test
    public void test() throws IOException, SAXException, ParserConfigurationException {
        BikeParsing bikeParsing = new BikeParsing("data/nextbike-test.xml");
        bikeParsing.parseData();
        assertEquals (8, bikeParsing.getCityList().size());


    }
    @Test
    public void testIfCityExists() throws IOException, SAXException, ParserConfigurationException {
        BikeParsing bikeParsing = new BikeParsing("data/nextbike-test.xml");
        bikeParsing.parseData();
        List<City> cities = bikeParsing.getCityList();
        assertEquals("Leipzig", cities.get(0).getName());
        assertEquals("Frankfurt", cities.get(1).getName());
    }

    @Test
    public void testNumbersOfPlaces() throws IOException, SAXException, ParserConfigurationException {
        BikeParsing bikeParsing = new BikeParsing("data/nextbike-test.xml");
        bikeParsing.parseData();
        List<City> cities = bikeParsing.getCityList();
        assertEquals(5, cities.get(0).getPlaceList().size());
        assertEquals(2, cities.get(1).getPlaceList().size());
    }
    @Test
    public void testNameOfCountry() throws IOException, SAXException, ParserConfigurationException {
        BikeParsing bikeParsing = new BikeParsing("data/nextbike-test.xml");
        bikeParsing.parseData();
        List<City> cities = bikeParsing.getCityList();
        assertEquals("Germany", cities.get(0).getCountryName());

}}