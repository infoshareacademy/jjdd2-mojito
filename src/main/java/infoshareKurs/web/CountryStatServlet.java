package infoshareKurs.web;

import infoshareKurs.BikeParsing;
import infoshareKurs.City;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

@WebServlet("/portal/countryStat")
public class CountryStatServlet extends HttpServlet {

    final Logger logger = LogManager.getLogger(CountryStatServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/countryStatGET.jsp");


        final BikeParsing bikeParsing = new BikeParsing("data/nextbike-live.xml");
        try {
            bikeParsing.parseData();
            Map<String, Integer> countryStats = new TreeMap<>();
            for (City city : bikeParsing.getCityList()) {
                if (countryStats.get(city.getCountryName()) == null) {
                    countryStats.put(city.getCountryName(), city.getPlaceList().size());
                } else {
                    int currentPointCount = countryStats.get(city.getCountryName());
                    countryStats.put(city.getCountryName(), currentPointCount + city.getPlaceList().size());
                }
            }

            List<CityPlace> places = new ArrayList<>();
            req.setAttribute("places", places);

            for (Map.Entry<String, Integer> country : countryStats.entrySet()) {
                String countryName = country.getKey();
                Integer stationsCount = country.getValue();
                places.add(new CityPlace(countryName, stationsCount));
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.warn("bład parsowania pliku");
        }
        requestDispatcher.forward(req, resp);
    }
}
