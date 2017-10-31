package infoshareKurs.web;

import infoshareKurs.Statistics;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@WebServlet("/portal/Statistics")
public class StatisticsServlet extends HttpServlet {

    @Inject
    Statistics statistics;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher
                ("/Statistics.jsp");

        List<CityPlace> places = new ArrayList<>();
        for (Map.Entry<String, Integer> stats : statistics.getStats().entrySet()) {
            String cityName = stats.getKey();
            Integer stationsCount = stats.getValue();
            places.add(new CityPlace(cityName, stationsCount));
        }

        req.setAttribute("places", places);

        requestDispatcher.forward(req, resp);
    }
}
