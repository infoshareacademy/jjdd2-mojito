package infoshareKurs.web;

import infoshareKurs.BikeParsing;
import infoshareKurs.Menu;
import infoshareKurs.MenuText;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Menu")
public class MenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

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
        writer.println("<div style=\"margin-top:15%;\">\n" +
                "      \n" +
                "      <div class=\"text-center\">");
        writer.println("<form action=\"nearestStation\" method=\"get\">");
        writer.println("<a href=\"nearestStation\"/>1.Wyszukanie najbliższej stacji rowerowej.</a>");
        writer.println("</form>");
        writer.println("<form action=\"country_stations\" method=\"get\">");
        writer.println("<a href=\"country_stations\"/>2.Wyszukanie stacji w danym kraju.</a>");
        writer.println("</form>");
        writer.println("<form action=\"city_stations\" method=\"get\">");
        writer.println("<a href=\"city_stations\"/>3.Wyszukanie stacji w danym mieście.");
        writer.println("</form>");
        writer.println("<form action=\"FindPlaceServlet\" method=\"get\">");
        writer.println("<a href=\"FindPlaceServlet\"/>4.Wyszukanie stacji rowerowej w konkretnej odległości.</a>");
        writer.println("</form>");
        writer.println("<form action=\"countryStat\" method=\"get\">");
        writer.println("<a href=\"countryStat\"/>5.Statystyki ilości stacji rowerowych w danym państwie.</a>");
        writer.println("</form>");
        writer.println("<form action=\"cityStat\" method=\"get\">");
        writer.println("<a href=\"cityStat\"/>6.Statystyki ilości stacji rowerowych w danym mieście</a>");
        writer.println("</form>");
        writer.println("</div>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
