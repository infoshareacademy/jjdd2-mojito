package infoshareKurs.web;

import infoshareKurs.database.beans.CountriesDAOBeanLocal;
import infoshareKurs.database.entities.CountriesEntity;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/baza")
public class Servlet extends HttpServlet {
    @Inject
    CountriesDAOBeanLocal countriesDAOBeanLocal;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CountriesEntity countriesEntity=new CountriesEntity();
countriesEntity.setName("DUPA");
countriesDAOBeanLocal.addCountriesEntity(countriesEntity);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
