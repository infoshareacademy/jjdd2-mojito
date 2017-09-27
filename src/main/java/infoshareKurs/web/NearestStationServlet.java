package infoshareKurs.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/nearest_station")
public class NearestStationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>\"Podaj swoje położenie geograficzną\"  </h1>");
        writer.println("<form action=\"nearest_station\" method=\"post\">");
        writer.println("<h2>\"Podaj szerokość geograficzną \n wzór XXXX.XXXX\"  </h2>");
        writer.println("<form action=\"nearest_station\" method=\"post\">");
        writer.println("<input type=\"text\" name=\"latitiudeUser\"/>");
        writer.println("<h2>\"Podaj szerokość geograficzną \n wzór XXXX.XXXX\"  </h2>");
        writer.println("</form>");
        writer.println("<form action=\"nearest_station\" method=\"post\">");
        writer.println("<input type=\"text\" name=\"longitudeUser\"/>");
        writer.println("<button type=\"submit\" />Send</button>");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
    }
}
