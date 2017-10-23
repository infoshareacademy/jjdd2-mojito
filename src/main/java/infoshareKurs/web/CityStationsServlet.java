package infoshareKurs.web;

import infoshareKurs.BikeParsing;
import infoshareKurs.City;
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

        writer.println("<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<link rel=\"stylesheet\" " +
                "href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css\"" +
                " integrity=\"sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M\"" +
                " crossorigin=\"anonymous\">\n" +
                "<script src=\"https://code.jquery.com/jquery-3.1.1.slim.min.js\" " +
                "integrity=\"sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n\"" +
                " crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js\"" +
                " integrity=\"sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb\" " +
                "crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js\"" +
                " integrity=\"sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn\"" +
                " crossorigin=\"anonymous\"></script>" +
                "</head>" +
                "<body class=\"bg-dark\">" +
                "<nav class=\"navbar navbar-dark bg-dark\" style=\" position: fixed;\n" +
                "    top: 0;\n" +
                "    width: 100%;\n" +
                "    border-bottom: 1px solid #666;" +
                "    z-index: 1;\">\n" +
                "  <span class=\"navbar-brand\"><b>Mohito Bike Project</b></span>\n" +
                "  <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\"" +
                " data-toggle=\"collapse\" data-target=\"#navbarText\" aria-controls=\"navbarText\"" +
                " aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
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
                "</nav>" +
                "<div style=\"margin-top:10%;\">\n" +
                "      \n" +
                "      <div class=\"text-center\">" +
                "<h1 class=\"text-white\"> Wpisz nazwę interesującego Cię Miasta. </h1>" +
                "</form>" +
                "<form action=\"city_stations\" method=\"post\">" +
                "<input type=\"text\" name=\"userCity\"/>" +
                "<button type=\"submit\" />Znajdz</button>" +
                "</form>" +
                "</body>" +
                "</html>");
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
            writer.println("<!DOCTYPE html>" +
                    "<html>" +
                    "<head>" +
                    "<link rel=\"stylesheet\" " +
                    "href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css\"" +
                    " integrity=\"sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M\"" +
                    " crossorigin=\"anonymous\">\n" +
                    "<script src=\"https://code.jquery.com/jquery-3.1.1.slim.min.js\" " +
                    "integrity=\"sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n\"" +
                    " crossorigin=\"anonymous\"></script>\n" +
                    "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js\"" +
                    " integrity=\"sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb\" " +
                    "crossorigin=\"anonymous\"></script>\n" +
                    "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js\"" +
                    " integrity=\"sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn\"" +
                    " crossorigin=\"anonymous\"></script>" +
                    "</head>" +
                    "<body class=\"bg-dark\">" +
                    "<nav class=\"navbar navbar-dark bg-dark\" style=\" position: fixed;\n" +
                    "    top: 0;\n" +
                    "    width: 100%;\n" +
                    "    border-bottom: 1px solid #666;" +
                    "    z-index: 1;\">\n" +
                    "  <span class=\"navbar-brand\"><b>Mohito Bike Project</b></span>\n" +
                    "  <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\"" +
                    " data-toggle=\"collapse\" data-target=\"#navbarText\" aria-controls=\"navbarText\"" +
                    " aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
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
                    "</nav>" +
                    "<div style=\"margin-top:5%;\">\n" +
                    "      \n" +
                    "      <div class=\"text-center\">" +
                    "<h1 class=\"text-white\"> Wpisz nazwę interesującego Cię Miasta. </h1>" +
                    "</form>" +
                    "<form action=\"city_stations\" method=\"post\" class=\"mb-4\">" +
                    "<input type=\"text\" name=\"userCity\"/>" +
                    "<button type=\"submit\" />Znajdz</button>" +
                    "</form>" +
                    "<span class=\"text-white\"> <h4><b> Stacje rowerowe znajdujące sie w " + inputdata +
                    "</h4></b></span> " +
                    "<div class=\"row justify-content-md-center\">" +
                    "<div class=\"col-5\">" +
                    "<table class=\"table table-striped mt-4 table-inverse table-hover\">\n" +
                    "  <thead class=\"thead-inverse\">\n" +
                    "    <tr>\n" +
                    "    </tr>\n" +
                    "  </thead>\n" +
                    "  <tbody>");
            for (City city : bikeParsing.getCityList()) {
                if (city.getName().equals(inputdata)) {
                    i++;
                    for (Place place : city.getPlaceList()) {
                        writer.println("<tr>" + "<td>" + place.getName() + "</td>" + "</tr>");
                        logger.debug("wypisanie stacji rowerowych znajdujacych sie danym kraju");
                    }
                    done = true;
                }
            }
            writer.println("<iframe width=\"600\" height=\"450\" frameborder=\"0\" style=\"border:0\"\n" +
                    "src=\"https://www.google.com/maps/embed/v1/search?q=47.5951518,-102.3316393&q=12.12,33.3&key=AIzaSyBhfSZFVEUausxMjtYoA-DeCfjM7wRgy0I\" allowfullscreen></iframe>");

            writer.println("</tbody>" +
                    "</table>" +
                    "</div>" );
            if (i == 0) {
                writer.println("<span class=\"text-white\"> <h4><b> Nie znaleziono miasta w bazie, wprowadź nazwę " +
                        "miasta ponownie. </h4></b></span>");
                done = true;
            }
            writer.println("</div>" + "</div>" + "</body>" + "</html>");
        }
    }
}