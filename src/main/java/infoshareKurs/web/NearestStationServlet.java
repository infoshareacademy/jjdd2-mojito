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
import java.util.List;
import infoshareKurs.Place;

@WebServlet("/nearest_station")
public class NearestStationServlet extends HttpServlet {

    List<City> cityList;


    String name;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>\"Podaj swoje położenie geograficzną\"  </h1>");
        writer.println("<form action=\"nearest_station\" method=\"post\">");
        writer.println("<h2>\"Podaj szerokość geograficzną \n wzór XXXX.XXXX\"  </h2>");
        writer.println("<form action=\"nearest_station\" method=\"post\">");
        writer.println("<input type=\"number\" step=\"any\" name=\"latitiudeUser\"/>");
        writer.println("<h2>\"Podaj szerokość geograficzną \n wzór XXXX.XXXX\"  </h2>");
        writer.println("</form>");
        writer.println("<form action=\"nearest_station\" method=\"post\">");
        writer.println("<input type=\"number\" step=\"any\" name=\"longitudeUser\"/>");
        writer.println("<button type=\"submit\" />Send</button>");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        resp.setContentType("text/html;charset=UTF-8");
//
//        PrintWriter writer = resp.getWriter();
//
//        final Logger logger = LogManager.getLogger(NearestStationServlet.class);
//
//        final BikeParsing bikeParsing = new BikeParsing(System.getProperty("java.io.tmpdir") + "/plik");
//
//        try {
//            bikeParsing.parseData();
//        } catch (ParserConfigurationException | SAXException | IOException e) {
//            logger.error("błąd parsowania pliku xml");
//            e.printStackTrace();
//        }
//
//        double[] userLocation = new double[2];
//        userLocation[0] = Double.parseDouble(req.getParameter("latitiudeUser"));
//        userLocation[1] = Double.parseDouble(req.getParameter("longitudeUser"));
//
//        Place place = new Place(bikeParsing)
//        double distance;
//
//        Double x = userLocation[0];
//        Double y = userLocation[1];
//
//
//        double k = place.getLatitiudePlace();
//        double j = place.getLongitudePlace();
//
//        distance = Math.sqrt(Math.pow((x - k), 2.0)
//                + Math.pow((Math.cos((x * Math.PI) / 180.0)
//                * (j - y)), 2.0)) * (40075.704 / 360.0);
//
//
//        logger.debug("znalezienie najblizszej stacji od miejsca uzytkownika");
//        double lowestDistance = 9999999999999999.9;
//        DistanceMath distanceMath = new DistanceMath();
//
//        for (City city : cityList) {
//            for (Place place : city.getPlaceList()) {
//                if (lowestDistance > distanceMath.countDistance(place, userLocation)) {
//                    lowestDistance = distanceMath.countDistance(place, userLocation);
//                    this.name = place.getName();
//                }
//            }
////        }
//        writer.format("Najbliższa stacja rowerowa znajduje się %.2f km od Ciebie. Stacja nazywa się %s"
//                , lowestDistance, this.name);
    }
}
