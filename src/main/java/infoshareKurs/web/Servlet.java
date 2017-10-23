package infoshareKurs.web;

import infoshareKurs.database.beans.CountriesDAOBeanLocal;
import infoshareKurs.database.entities.CountriesEntity;

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
import java.util.List;


@WebServlet("/baza")
public class Servlet extends HttpServlet {
    @PersistenceContext(name = "statistics")
    EntityManager entityManager;
    @Inject
    CountriesDAOBeanLocal countriesDAOBeanLocal;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer=response.getWriter();

        CountriesEntity countriesEntity = new CountriesEntity();

        // wrzucanie statystyk do danej tabeli
        countriesEntity.setName("Wrzucenie do bazy danych34 ");
        countriesEntity.setNumber(1);
        countriesDAOBeanLocal.addCountriesEntity(countriesEntity);

// lista ze statystykami pobranymi z bazy mysql
//        List<CountriesEntity> countriesEntities =entityManager.createNamedQuery("infoshareKurs.database.entities.CountriesEntity.dsc",CountriesEntity.class).getResultList();
//
//        for (CountriesEntity c:countriesEntities
//             ) {writer.println(c.getName());
//
//        }

List<String> countriesEntities= countriesDAOBeanLocal.getAll();

        for (String c:countriesEntities) {
            writer.println(c );


        }


    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
