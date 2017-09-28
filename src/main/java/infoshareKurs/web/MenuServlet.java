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

    private Menu menu = new Menu();
    private MenuText menuText = new MenuText();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<form action=\"nearest_station\" method=\"get\">");
        writer.println("<button type=\"Submit\"/>1.Wyszukanie najbliższej stacji rowerowej.</button>");
        writer.println("</form>");
        writer.println("<form action=\"Menu\" method=\"post\">");
        writer.println("<button type=\"Submit\"/>2.Wyszukanie stacji w danym kraju.</button>");
        writer.println("</form>");
        writer.println("<form action=\"Menu\" method=\"post\">");
        writer.println("<button type=\"Submit\"/>3.Wyszukanie stacji w danym mieście.");
        writer.println("</form>");
        writer.println("<form action=\"Menu\" method=\"post\">");
        writer.println("<button type=\"Submit\"/>4.Wyszukanie stacji rowerowej w konkretnej odległości.</button>");
        writer.println("</form>");
        writer.println("<form action=\"Menu\" method=\"post\">");
        writer.println("<button type=\"Submit\"/>5.Statystyki ilości stacji rowerowych w danym państwie.</button>");
        writer.println("</form>");
        writer.println("<form action=\"Menu\" method=\"post\">");
        writer.println("<button type=\"Submit\"/>6.Statystyki ilości stacji rowerowych w danym mieście</button>");
        writer.println("</form>");
        writer.println("<form action=\"Menu\" method=\"post\">");
        writer.println("<button type=\"Submit\"/>7.Wyjście z progarmu</button>");
        writer.println("</form>");
        writer.println("<form action=\"Menu\" method=\"post\" enctype=\"multipart/form-data\">");
        writer.println("<input type=\"file\" name=\"file\"/>");
        writer.println("<button type=\"submit\" />Upload file</button>");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String x = "lubie frytki";
        resp.getWriter().print(x);
    }
}
