package infoshareKurs.web;

import infoshareKurs.GetCityStatistics;
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

@WebServlet("/portal/GetCityStatistics")
public class CityStatisticsServlet extends HttpServlet {

    @Inject
    GetCityStatistics getCityStatistics;

    @Inject
    CityDAOBeanLocal cityDAOBeanLocal;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher
                ("/GetCityStatistics.jsp");

        for (Map.Entry<String, Integer> stats : getCityStatistics.getStats().entrySet()) {
            String cityName = stats.getKey();
            Integer stationsCount = stats.getValue();
            CityEntity cityEntity = new CityEntity();
            cityEntity.setName(cityName);
            cityEntity.setNumber(stationsCount);
            cityDAOBeanLocal.addCitiesEntity(cityEntity);
        }

        getCityStatistics.getStats().clear();

        List<CityStatistics> places = cityDAOBeanLocal.cityQueryList();

        req.setAttribute("places", places);

        requestDispatcher.forward(req, resp);
    }
}