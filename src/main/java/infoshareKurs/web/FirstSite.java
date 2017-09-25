package infoshareKurs.web;

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
public class FirstSite extends HttpServlet {

    private Menu menu = new Menu();
    private MenuText menuText = new MenuText();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<form action=\"Menu\" method=\"post\">");
        writer.println("<input type=\"text\" name=\"userinput\"/>");
        writer.println("<button type=\"submit\" />Submit</button>");
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
