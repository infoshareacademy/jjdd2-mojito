package infoshareKurs.web;

import infoshareKurs.BikeParsing;
import infoshareKurs.GeoLocation;
import infoshareKurs.NearestPlace;
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

@WebServlet("/FindPlaceServlet")
public class FindPlaceServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h2>\"Wpisz odległosć wyszukiwania stacji . </h2>");
        writer.println("</form>");
        writer.println("<form action=\"FindPlaceServlet\" method=\"post\">");
        writer.println("<input type=\"number\" name=\"choosenRadius\"/>");
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

        final Logger logger = LogManager.getLogger(FindPlaceServlet.class);

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

        NearestPlace nearestPlace = new NearestPlace(bikeParsing.getCityList());
        writer.println(nearestPlace.findPlace(geoLocation ,distance));

    }
}
