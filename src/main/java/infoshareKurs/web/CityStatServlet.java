package infoshareKurs.web;
import infoshareKurs.BikeParsing;
import infoshareKurs.City;
import infoshareKurs.StatCountry;
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
import java.util.Collections;
import java.util.Comparator;

@WebServlet("/cityStat")
public class CityStatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        final Logger logger = LogManager.getLogger(CityStatServlet.class);

        final BikeParsing bikeParsing = new BikeParsing(System.getProperty("java.io.tmpdir") + "/plik");

        try {
            bikeParsing.parseData();
            Collections.sort(bikeParsing.getCityList(), new Comparator<City>() {
                public int compare(City c1, City c2) {
                    if (c1.getPlaceList().size() < c2.getPlaceList().size()) {
                        return 1;
                    } else if (c1.getPlaceList().size() > c2.getPlaceList().size()) {
                        return -1;
                    }
                    return c1.getName().compareTo(c2.getName());
                }
            });
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css\" integrity=\"sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M\" crossorigin=\"anonymous\">\n");
            writer.println("<script src=\"https://code.jquery.com/jquery-3.1.1.slim.min.js\" integrity=\"sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n\" crossorigin=\"anonymous\"></script>\n" +
                    "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js\" integrity=\"sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb\" crossorigin=\"anonymous\"></script>\n" +
                    "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js\" integrity=\"sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn\" crossorigin=\"anonymous\"></script>");
            writer.println("</head>");
            writer.println("<body class=\"bg-dark\">");
            writer.println("<nav class=\"navbar navbar-dark bg-dark\">\n" +
                    "  <span class=\"navbar-brand\">Mohito Bike Project</span>\n" +
                    "  <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarText\" aria-controls=\"navbarText\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                    "    <span class=\"navbar-toggler-icon\"></span>\n" +
                    "  </button>\n" +
                    "  <div class=\"collapse navbar-collapse\" id=\"navbarText\">\n" +
                    "    <ul class=\"navbar-nav mr-auto\">\n" +
                    "      <li class=\"nav-item\">\n" +
                    "        <a class=\"nav-link\" href=\"nearestStation\">Najblizsza stacja</a>\n" +
                    "      </li>\n" +
                    "      <li class=\"nav-item\">\n" +
                    "        <a class=\"nav-link\" href=\"country_stations\">stacje w kraju</a>\n" +
                    "      </li>\n" +
                    "      <li class=\"nav-item\">\n" +
                    "        <a class=\"nav-link\" href=\"city_stations\">stacje w miescie</a>\n" +
                    "      </li>\n" +
                    "      <li class=\"nav-item\">\n" +
                    "        <a class=\"nav-link\" href=\"FindPlaceServlet\">wyszukanie stacji w promieniu</a>\n" +
                    "      </li>\n" +
                    "      <li class=\"nav-item\">\n" +
                    "        <a class=\"nav-link\" href=\"countryStat\">statystyki panst</a>\n" +
                    "      </li>\n" +
                    "      <li class=\"nav-item\">\n" +
                    "        <a class=\"nav-link\" href=\"cityStat\">statystyki miast</a>\n" +
                    "      </li>\n" +
                    "    </ul>\n" +
                    "  </div>\n" +
                    "</nav>");
            writer.println("<div style=\"margin-top:5%;\">\n" +
                    "      \n" +
                    "      <div class=\"text-center\">");
            for (City city : bikeParsing.getCityList()) {
                writer.println("<span class=\"text-white text-center align-middle\"> Liczba stacji rowerowych w mieście "
                        + city.getName() + " : " + city.getPlaceList().size() + "</span>");
                writer.println("<br>");
            }
            writer.println("</body>");
            writer.println("</html>");
        } catch (
                ParserConfigurationException | SAXException | IOException e) {
            logger.warn("blad parsowania pliku");
        }
    }
}
