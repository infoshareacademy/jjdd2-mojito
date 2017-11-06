package infoshareKurs.web;

import infoshareKurs.*;
import infoshareKurs.database.beans.CityDAOBeanLocal;
import infoshareKurs.database.beans.CountryDAOBeanLocal;
import infoshareKurs.database.entities.CityEntity;
import infoshareKurs.database.entities.CountryEntity;
import org.apache.commons.lang3.StringUtils;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/portal/FindPlaceServlet")
public class FindPlaceServlet extends HttpServlet {

    @Inject
    GetCityStatistics getCityStatistics;

    @Inject
    CityDAOBeanLocal cityDAOBeanLocal;

    @Inject
    CountryDAOBeanLocal countryDAOBeanLocal;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/findplaceGET.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        final Logger logger = LogManager.getLogger(FindPlaceServlet.class);
        try {

            req.getSession().setAttribute("formatEx", false);

            final BikeParsing bikeParsing = new BikeParsing("data/nextbike-live.xml");

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

            List<String> distinctCityNames = new ArrayList<>();
            for (Place place : placelist) {
                String cityName = StringUtils.stripAccents(place.getCity());

                if (distinctCityNames.contains(cityName)) {
                    continue;
                }
                distinctCityNames.add(cityName);
                CityEntity cityEntity = new CityEntity();
                cityEntity.setName(cityName);
                cityEntity.setNumber(1);
                cityDAOBeanLocal.addCitiesEntity(cityEntity);
            }

            requestDispatcher.forward(req, resp);

            }
             catch(Exception e){
                logger.warn("format exeption", e);
                req.getSession().setAttribute("formatEx", true);
                req.getRequestDispatcher("/findplaceGET.jsp").forward(req, resp);
        }
    }
}