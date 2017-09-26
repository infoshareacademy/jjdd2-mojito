package infoshareKurs.web;

import infoshareKurs.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/country_stations")
public class CountryStationsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Stacje znajdujace sie w danym kraju.");
    }
}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Logger logger = LogManager.getLogger(CountryStations.class);

        final BikeParsing bikeParsing = new BikeParsing("/tmp/hsperfdata_mkoniuszy/plik");
        try {
            bikeParsing.parseData();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error("błąd parsowania pliku xml");
            e.printStackTrace();
        }
        System.out.println("Wpisz nazwę interesującego Cię państwa.");
        boolean done = false;
        while (!done) {
            UserInputReader inputcountry = new UserInputReader();
            String inputdata = inputcountry.readlineString();

            int i = 0;
            System.out.format("Stacje rowerowe znajdujące sie w %s :\n", inputdata);
            for (City city : bikeParsing.getCityList()) {
                if (city.getCountryName().equals(inputdata)) {
                    i++;
                    for (Place place : city.getPlaceList()) {
                        System.out.println(place.getName() +"  /  "+city.getName());
                        logger.debug("wypisanie stacji rowerowych znajdujacych sie danym kraju");
                    }
                }
                done = true;
            }
            if (i == 0) {
                System.out.println("Nie znaleziono państwa w bazie, wprowadź nazwę ponownie.");
                logger.info("nie znaleziono kraju w bazie danych ");
            }
        }
    }
}
