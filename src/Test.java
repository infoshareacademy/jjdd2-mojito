import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        //test try catch-
        try { //wyjątek
            BikeParsing bikeParsing = new BikeParsing("nextbike-live.xml");
            bikeParsing.parseData();
            bikeParsing.showData();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            //wypisuje gdzie był wyjatek
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
