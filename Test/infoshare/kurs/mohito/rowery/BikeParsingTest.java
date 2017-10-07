package infoshare.kurs.mohito.rowery;

import infoshareKurs.BikeParsing;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class BikeParsingTest {

    @Test
    public void test() throws IOException, SAXException, ParserConfigurationException {
        BikeParsing bikeParsing = new BikeParsing("data/nextbike-test.xml");
        bikeParsing.parseData();

        assertEquals(8, bikeParsing.getCityList().size());
    }

}