package infoshareKurs.web;

import infoshareKurs.Email.EmailService;

import infoshareKurs.GetCityStatistics;
import infoshareKurs.database.CityStatistics;
import infoshareKurs.database.beans.CityDAOBeanLocal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/portal/Email")
public class EmailServlet extends HttpServlet {

    @Inject
    GetCityStatistics getCityStatistics;

    @Inject
    CityDAOBeanLocal cityDAOBeanLocal;

    private final Logger logger = LogManager.getLogger("log4j-burst-filter");


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/EmailDoGet.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        EmailService email = new EmailService("mojitobikeproject@gmail.com",
                "bikeproject1", "smtp.gmail.com", 465);
        logger.info("Utworzono obiekt klasy EmailService.");
        try {
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/EmailDoPost.jsp");

            StringBuilder sb = new StringBuilder();
            List<CityStatistics> places = cityDAOBeanLocal.cityQueryList();

            for (CityStatistics city : places
                    ) {
                String cityName = city.getName();
                Integer stationsCount = city.getNumber();
                sb.append(cityName + " - " + stationsCount + "\n");

            }

            email.send("mojitobikeproject@gmail.com",
                    "Statystyki wyswietleń miast z " + Instant.now(),
                    sb.toString());
            dispatcher.forward(req, resp);
        } catch (MessagingException e) {
            logger.error("Pojawił się błąd podczas wysyłania e-maila: " + e);
            resp.sendRedirect("EmailError");
            return;
        }
    }
}
