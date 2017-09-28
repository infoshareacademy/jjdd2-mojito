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
        writer.println("<body>");
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
        writer.println("</body>");
        writer.println("</html>");
    }
}
