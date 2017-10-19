package infoshareKurs.web;

import infoshareKurs.database.beans.CountriesDAOBeanLocal;
import infoshareKurs.database.entities.CitiesEntity;
import infoshareKurs.database.entities.CountriesEntity;

import javax.inject.Inject;
import javax.management.Query;
import javax.persistence.EntityManager;
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
    EntityManager entityManager;
    @Inject
    CountriesDAOBeanLocal countriesDAOBeanLocal;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CountriesEntity countriesEntity = new CountriesEntity();
        countriesEntity.setName("Wrzucenie do bazy danych34 ");
        countriesEntity.setNumber(1);
        countriesDAOBeanLocal.addCountriesEntity(countriesEntity);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
