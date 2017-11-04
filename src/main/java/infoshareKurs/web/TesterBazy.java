package infoshareKurs.web;


import infoshareKurs.database.CityStatistics;
import infoshareKurs.database.beans.CityDAOBeanLocal;
import infoshareKurs.database.beans.CountryDAOBeanLocal;
import infoshareKurs.database.entities.CityEntity;
import infoshareKurs.database.entities.CountryEntity;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/baza")
public class TesterBazy extends HttpServlet {
    @PersistenceContext(name = "statistics")
    EntityManager entityManager;
    @Inject
    CityDAOBeanLocal cityDAOBeanLocal;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        for (int i = 0; i < 10; i++) {
            CityEntity countriesEntity = new CityEntity();

            // wrzucanie statystyk do danej tabeli
            countriesEntity.setName("Wrzucenie do bazy danych34 ");
            countriesEntity.setNumber(1);
            cityDAOBeanLocal.addCitiesEntity(countriesEntity);
        }


        List<CityStatistics> cityStatistics = cityDAOBeanLocal.cityQueryList();

        for (CityStatistics c : cityStatistics) {
            writer.println(c.getName() + c.getNumber());
        }

    }

// lista ze statystykami pobranymi z bazy mysql
//        List<CountriesEntity> countriesEntities =entityManager.createNamedQuery("infoshareKurs.database.entities.CountriesEntity.dsc",CountriesEntity.class).getResultList();
//
//        for (CountriesEntity c:countriesEntities
//             ) {writer.println(c.getName());
//
//        }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
