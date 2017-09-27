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

@WebServlet("country_stations")
public class CountryStationsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>\"Wpisz nazwę interesującego Cię państwa. </h1>");
        writer.println("</form>");
        writer.println("<form action=\"country_stations\" method=\"post\">");
        writer.println("<input type=\"text\" name=\"userCountry\"/>");
        writer.println("<button type=\"submit\" />Send</button>");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        final Logger logger = LogManager.getLogger(CountryStations.class);
        final BikeParsing bikeParsing = new BikeParsing(System.getProperty("java.io.tmpdir") + "/plik");
        try {
            bikeParsing.parseData();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error("błąd parsowania pliku xml");
            e.printStackTrace();
        }

        boolean done = false;
        while (!done) {
            String inputdata = req.getParameter("userCountry");
            int i = 0;
            writer.println("Stacje rowerowe znajdujące sie w  " + inputdata);
            for (City city : bikeParsing.getCityList()) {
                if (city.getCountryName().equals(inputdata)) {
                    i++;
                    for (Place place : city.getPlaceList()) {
                        writer.println(place.getName() + "  /  " + city.getName());
                        writer.println("<br>");
                        logger.debug("wypisanie stacji rowerowych znajdujacych sie danym kraju");
                    }
                }
                done = true;
            }
            if (i == 0) {
                writer.println("Nie znaleziono państwa w bazie, wprowadź nazwę ponownie.");
                logger.info("nie znaleziono kraju w bazie danych ");
                done = true;
            }
        }
    }
}
