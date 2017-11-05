package infoshareKurs.web;

import infoshareKurs.Email.EmailService;
import infoshareKurs.Statistics;
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

    private final Logger logger = LogManager.getLogger("log4j-burst-filter");

    @Inject
    Statistics statistics;

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
            for (Map.Entry<String, Integer> stats : statistics.getStats().entrySet()) {
                String cityName = stats.getKey();
                Integer stationsCount = stats.getValue();
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
