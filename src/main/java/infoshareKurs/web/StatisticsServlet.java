package infoshareKurs.web;

import infoshareKurs.Statistics;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/portal/Statistics")
public class StatisticsServlet extends HttpServlet{

    @Inject
    private Statistics statistics;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        resp.getWriter().print("Najczęściej wyszukiwane miasta: ");
        resp.getWriter().print(statistics.getStats());

    }



}
