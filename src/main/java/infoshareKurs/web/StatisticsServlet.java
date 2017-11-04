package infoshareKurs.web;

import infoshareKurs.Statistics;
import infoshareKurs.database.CityStatistics;
import infoshareKurs.database.beans.CityDAOBeanLocal;
import infoshareKurs.database.entities.CityEntity;

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

    @Inject
    CityDAOBeanLocal cityDAOBeanLocal;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher
                ("/Statistics.jsp");

        for (Map.Entry<String, Integer> stats : statistics.getStats().entrySet()) {
            String cityName = stats.getKey();
            Integer stationsCount = stats.getValue();
            CityEntity cityEntity = new CityEntity();
            cityEntity.setName(cityName);
            cityEntity.setNumber(stationsCount);
            cityDAOBeanLocal.addCitiesEntity(cityEntity);
        }

        statistics.getStats().clear();

        List<CityStatistics> places = cityDAOBeanLocal.cityQueryList();

        req.setAttribute("places", places);

        requestDispatcher.forward(req, resp);
    }
}