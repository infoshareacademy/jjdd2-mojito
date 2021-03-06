package infoshareKurs.web;

import infoshareKurs.*;

import infoshareKurs.database.beans.CityDAOBeanLocal;
import infoshareKurs.database.entities.CityEntity;
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

@WebServlet("/portal/nearestStation")
public class NearestStationServlet extends HttpServlet {

    @Inject
    GetCityStatistics getCityStatistics;

    @Inject
    CityDAOBeanLocal cityDAOBeanLocal;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/nearestPlaceGET.jsp");
        req.getSession().setAttribute("formatEx", false);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(NearestStationServlet.class);

        try {
            req.getSession().setAttribute("formatEx", false);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/nearestPlacePOST.jsp");

            GeoLocation geoLocation = new GeoLocation();
            if (req.getParameter("latitiudeUser") != null && req.getParameter("longitudeUser") != null) {
                String userlat = req.getParameter("latitiudeUser");
                String userLng = req.getParameter("longitudeUser");
                geoLocation.setLatitiudeUser(Double.parseDouble(userlat));

                geoLocation.setLongitudeUser(Double.parseDouble(userLng));
            }

            final BikeParsing bikeParsing = new BikeParsing("data/nextbike-live.xml");


            bikeParsing.parseData();

            NearestPlaceFinder nearestPlace = new NearestPlaceFinder(bikeParsing.getCityList());
            Place foundedPlace = nearestPlace.findNearestPlace(geoLocation);
            Double destLat = foundedPlace.getLatitudePlace();
            Double destLng = foundedPlace.getLongitudePlace();

            String destination = destLat+","+destLng;
            req.setAttribute("longitudeUser", req.getParameter("latitiudeUser"));
            req.setAttribute("latitiudeUser", req.getParameter("longitudeUser"));
            req.setAttribute("destLat", destLat);
            req.setAttribute("destLng", destLng);
            req.setAttribute("destination", destination);
            req.setAttribute("destinationStationName", foundedPlace.getName());
            
            String cityName = StringUtils.stripAccents(foundedPlace.getCity());
            CityEntity cityEntity = new CityEntity();
            cityEntity.setName(cityName);
            cityEntity.setNumber(1);
            cityDAOBeanLocal.addCitiesEntity(cityEntity);

            requestDispatcher.forward(req, resp);
        }
        catch (Exception e) {
            logger.warn("format exeption", e);
            req.getSession().setAttribute("formatEx", true);
            req.getRequestDispatcher("/nearestPlaceGET.jsp").forward(req, resp);
        }
    }
}