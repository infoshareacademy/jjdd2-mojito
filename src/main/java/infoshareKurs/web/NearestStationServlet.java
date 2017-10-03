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

@WebServlet("/nearestStation")
public class NearestStationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>\"Podaj swoje położenie geograficzną\"  </h1>");
        writer.println("<form action=\"nearestStation\" method=\"post\">");
        writer.println("<h2>\"Podaj szerokość geograficzną \n wzór XXXX.XXXX\"  </h2>");
        writer.println("<form action=\"nearestStation\" method=\"post\">");
        writer.println("<input type=\"text\"name=\"latitiudeUser\"/>");
        writer.println("<h2>\"Podaj szerokość geograficzną \n wzór XXXX.XXXX\"  </h2>");
        writer.println("<input type=\"text\"name=\"longitudeUser\"/>");
        writer.println("<button type=\"submit\" />Znajdz</button>");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        GeoLocation geoLocation = new GeoLocation();

        geoLocation.setLatitiudeUser(Double.parseDouble(req.getParameter("latitiudeUser")));

        geoLocation.setLongitudeUser(Double.parseDouble(req.getParameter("longitudeUser")));


        final Logger logger = LogManager.getLogger(NearestStationServlet.class);

        final BikeParsing bikeParsing = new BikeParsing(System.getProperty("java.io.tmpdir") + "/plik");

        try {
            bikeParsing.parseData();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error("błąd parsowania pliku xml");
        }

        NearestPlace nearestPlace = new NearestPlace(bikeParsing.getCityList());
        nearestPlace.findNearestPlace(geoLocation);

        writer.println(nearestPlace.findNearestPlace(geoLocation));
    }
}
