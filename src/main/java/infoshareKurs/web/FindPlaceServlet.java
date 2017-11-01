package infoshareKurs.web;

import infoshareKurs.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/portal/FindPlaceServlet")
public class FindPlaceServlet extends HttpServlet {

    @Inject
    private Statistics statistics;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/findplaceGET.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(FindPlaceServlet.class);
        try{
            req.getSession().setAttribute("formatEx",false);

            final BikeParsing bikeParsing = new BikeParsing(System.getProperty("java.io.tmpdir") + "/plik");

            GeoLocation geoLocation = new GeoLocation();

            geoLocation.setLatitiudeUser(Double.parseDouble(req.getParameter("latitiudeUser")));

            geoLocation.setLongitudeUser(Double.parseDouble(req.getParameter("longitudeUser")));

            double distance = Double.parseDouble(req.getParameter("choosenRadius"));


            try {
                bikeParsing.parseData();
            } catch (ParserConfigurationException | SAXException | IOException e) {
                logger.error("błąd parsowania pliku xml");

            }
                PlaceFinder placeFinder = new PlaceFinder(bikeParsing.getCityList());

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/findplacePOST.jsp");

                List<Place> placelist = placeFinder.findPlace(geoLocation, distance);
                if (placelist.size() == 0) {
                    requestDispatcher = req.getRequestDispatcher("/findplacePOST.jsp");
                }

                req.setAttribute("places", placelist);

                requestDispatcher.forward(req, resp);

                List<String> distinctCityNames = new ArrayList<>();
                for (Place place : placelist) {
                    String cityName = place.getCity();

                    if (distinctCityNames.contains(cityName)) {
                        continue;
                    }

                    distinctCityNames.add(cityName);
                    statistics.add(cityName);
                }
        } catch (Exception e) {
            logger.warn("format exeption", e);
            req.getSession().setAttribute("formatEx", true);
            req.getRequestDispatcher("/nearestPlaceGET.jsp").forward(req, resp);
        }
    }
}
