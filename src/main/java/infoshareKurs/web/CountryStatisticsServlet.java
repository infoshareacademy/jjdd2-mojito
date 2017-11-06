package infoshareKurs.web;

import infoshareKurs.GetContryStatistics;
import infoshareKurs.database.CountryStatistics;
import infoshareKurs.database.beans.CountryDAOBeanLocal;
import infoshareKurs.database.entities.CountryEntity;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/portal/CountryStatistics")
public class CountryStatisticsServlet extends HttpServlet {

    @Inject
    GetContryStatistics getContryStatistics;

    @Inject
    CountryDAOBeanLocal countryDAOBeanLocal;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher
                ("/CountryStatistics.jsp");

        for (Map.Entry<String, Integer> stats : getContryStatistics.getStats().entrySet()) {
            String countryName = stats.getKey();
            Integer stationsCount = stats.getValue();
            CountryEntity countryEntity = new CountryEntity();
            countryEntity.setName(countryName);
            countryEntity.setNumber(stationsCount);
            countryDAOBeanLocal.addCountriesEntity(countryEntity);
        }

        getContryStatistics.getStats().clear();

        List<CountryStatistics> places = countryDAOBeanLocal.countryQueryList();

        req.setAttribute("places", places);

        requestDispatcher.forward(req, resp);
    }
}