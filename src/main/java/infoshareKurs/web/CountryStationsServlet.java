package infoshareKurs.web;

import infoshareKurs.*;
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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/portal/country_stations")
public class CountryStationsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/CountryStationsGet.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        final Logger logger = LogManager.getLogger(CountryStationsServlet.class);

        final BikeParsing bikeParsing = new BikeParsing(System.getProperty("java.io.tmpdir") + "/plik");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/CountryStationsPost.jsp");

        try {
            bikeParsing.parseData();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error("błąd parsowania pliku xml");
            e.printStackTrace();
        }

        boolean done = false;

        while (!done) {
            int i = 0;
            req.setAttribute("userCountry",req.getParameter("userCountry" ));
            List<Place> places = new ArrayList<>();

            for (City city : bikeParsing.getCityList()) {
                if (city.getCountryName().equals(req.getParameter("userCountry" ))) {
                    i++;
                    for (Place place : city.getPlaceList()) {
                        places.add(place);
//                        writer.println("<tr>" + "<td>" + place.getName() + "</td><td>" + city.getName() +
//                                "</td>" + "</tr>");
                        logger.debug("wypisanie stacji rowerowych znajdujacych sie danym kraju");
                    }
                }
                done = true;
            }
            req.setAttribute("places", places);
//            writer.println("</tbody>" + "</table>");

            if (i == 0) {
//                writer.println("Nie znaleziono państwa w bazie, wprowadź nazwę ponownie.");
                logger.info("nie znaleziono kraju w bazie danych ");
                done = true;
            }
            requestDispatcher.forward(req, resp);
//      writer.println("</body>" + "</html>");
        }

    }
}
