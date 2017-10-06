package infoshareKurs.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet("/Welcome")
@MultipartConfig
public class WelcomeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>Witaj w wyszukiwarce stacji rowerowych. </h1>");
        writer.println("<h2>Wczytaj plik Xml do bazy danych. </h2>");
        writer.println("<form action=\"Welcome\" method=\"post\" enctype=\"multipart/form-data\">");
        writer.println("<input type=\"file\" name=\"userFile\"/>");
        writer.println("<button type=\"submit\" />Załaduj plik</button>");
        writer.println("</form>");

        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(WelcomeServlet.class);

        try {
            Part userfile = null;
            userfile = req.getPart("userFile");
            InputStream inputStream = null;
            inputStream = userfile.getInputStream();
            String tmpDir = System.getProperty("java.io.tmpdir");
            tmpDir = tmpDir + "/plik";
            OutputStream outputStream = null;
            outputStream = new FileOutputStream(new File(tmpDir));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            resp.getWriter().println("<!DOCTYPE html>");
            resp.getWriter().println("<html>");
            resp.getWriter().println("<body>");
            resp.getWriter().println("<h1>Twoj plik zostal wczytany </h1>");
            resp.getWriter().println("<form action=\"Menu\" method=\"get\">");
            resp.getWriter().println("<button type=\"submit\" />Przejdz do menu</button>");
            resp.getWriter().println("</form>");
            resp.getWriter().println("</body>");
            resp.getWriter().println("</html>");
        } catch (IOException | ServletException e) {
            logger.warn("bład wczytania pliku");
        }
    }
}
