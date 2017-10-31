package infoshareKurs.web;

import infoshareKurs.Email.EmailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;

@WebServlet("/portal/Email")
public class EmailServlet extends HttpServlet {

    private final Logger logger = LogManager.getLogger("log4j-burst-filter");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/EmailDoGet.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmailService email = new EmailService("mojitobikeproject@gmail.com", "bikeproject1", "smtp.gmail.com", 465);
        logger.info("Utworzono obiekt klasy EmailService.");
        try {
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/EmailDoPost.jsp");
            email.setContent();
            email.send("mojitobikeproject@gmail.com", "Statystyki wyswietleń miast z " + Instant.now(), "Object");
            dispatcher.forward(req, resp);
        } catch (MessagingException e) {
            //e.printStackTrace();
            logger.error("Pojawił się błąd podczas wysyłania e-maila: " + e.getMessage());
            resp.sendRedirect("EmailError");
            return;
        }
    }
}
