package infoshareKurs;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Menu {
    public static void main(String[] args) {

        Configuration config = ConfigurationLoader.getConfiguration();

        System.setProperty("log4j.configurationFile", "log4j.xml");

        Logger logger = LogManager.getLogger(config.getLogPath());
        logger.info("This is logger with file appender");
        try {
            BikeParsing bikeParsing = new BikeParsing(config.getBikeDataPath());
            bikeParsing.parseData();
            logger.info("Parsowanie pliku xml");

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

