package infoshareKurs.web;

import infoshareKurs.BikeParsing;
import infoshareKurs.City;
import infoshareKurs.CountryStations;
import infoshareKurs.Place;
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

@WebServlet("/city_stations")
public class CityStationsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>\"Wpisz nazwę interesującego Cię Miasta. </h1>");
        writer.println("</form>");
        writer.println("<form action=\"city_stations\" method=\"post\">");
        writer.println("<input type=\"text\" name=\"userCity\"/>");
        writer.println("<button type=\"submit\" />Send</button>");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        final Logger logger = LogManager.getLogger(CityStationsServlet.class);

        final BikeParsing bikeParsing = new BikeParsing(System.getProperty("java.io.tmpdir") + "/plik");

        try {
            bikeParsing.parseData();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error("błąd parsowania pliku xml");
        }

        boolean done = false;

        while (!done) {
            String inputdata = req.getParameter("userCity");
            int i = 0;
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css\" integrity=\"sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M\" crossorigin=\"anonymous\">");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>\"Wpisz nazwę interesującego Cię Miasta. </h1>");
            writer.println("</form>");
            writer.println("<form action=\"city_stations\" method=\"post\">");
            writer.println("<input type=\"text\" name=\"userCity\"/>");
            writer.println("<button type=\"submit\" />Send</button>");
            writer.println("</form>");
            writer.println("Stacje rowerowe znajdujące sie w  " + inputdata);
            writer.println("<table class=\"table table-hover\">\n" +
                    "  <thead class=\"thead-inverse\">\n" +
                    "    <tr>\n" +
                    "      <th>Stacja</th>\n" +
                    "    </tr>\n" +
                    "  </thead>\n" +
                    "  <tbody>");
            for (City city : bikeParsing.getCityList()) {
                if (city.getName().equals(inputdata)) {
                    i++;
                    for (Place place : city.getPlaceList()) {
                        writer.println("<tr>");
                        writer.println("<td>" + place.getName() + "</td>");
                        writer.println("</tr>");
                        logger.debug("wypisanie stacji rowerowych znajdujacych sie danym kraju");
                    }
                    done = true;
                }

            }
            writer.println("</tbody>" +
                    "</table>");
            if (i == 0) {
                writer.println("Nie znaleziono miasta w bazie, wprowadź nazwę miasta ponownie.");
            }
            writer.println("</body>");
            writer.print("</html>");
        }
    }
}