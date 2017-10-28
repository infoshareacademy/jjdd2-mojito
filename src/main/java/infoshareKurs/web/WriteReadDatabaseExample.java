//package infoshareKurs.web;
//
//import infoshareKurs.database.CountryStatistics;
//import infoshareKurs.database.beans.CountryDAOBeanLocal;
//import infoshareKurs.database.entities.CountryEntity;
//
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//@WebServlet("/baza")
//public class WriteReadDatabaseExample extends HttpServlet {
//    @PersistenceContext(name = "statistics")
//    EntityManager entityManager;
//    @Inject
//    CountryDAOBeanLocal countryDAOBeanLocal;
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter writer = response.getWriter();
//
//        CountryEntity countryEntity = new CountryEntity();
//
//        // wrzucanie statystyk do danej tabeli
//
//        //Nazwa państwa
//
//        countryEntity.setName("Name");
//
//        //ilość wyszykiwań
//
//        countryEntity.setNumber(1);
//        countryDAOBeanLocal.addCountriesEntity(countryEntity);
//
//        List<CountryStatistics> countriesEntities = countryDAOBeanLocal.countryQueryList();
//
//        for (CountryStatistics c : countriesEntities) {
//            writer.println(c.getName() + c.getNumber());
//        }
//    }
//
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    }
//}
