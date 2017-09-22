package infoshareKurs;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Menu {
    private final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        try {
            BikeParsing bikeParsing = new BikeParsing("testdata/nextbike-live.xml");
            bikeParsing.parseData();

            MenuText menuText = new MenuText();
            menuText.Text();
            UserChooseFromMenu choose = new UserChooseFromMenu();
            choose.userChooseFromMenu(bikeParsing.getCityList());

            DistanceMath distanceMath = new DistanceMath();
            String placename = "";

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}

