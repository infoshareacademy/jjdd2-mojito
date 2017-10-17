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

@WebServlet("/portal/Welcome")
@MultipartConfig
public class WelcomeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                " <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css\" integrity=\"sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M\" crossorigin=\"anonymous\">" +
                "  <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
                "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js\" integrity=\"sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4\" crossorigin=\"anonymous\"></script>\n" +
                "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js\" integrity=\"sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1\" crossorigin=\"anonymous\"></script>" +


                "</head>" +
                "<body class=\"bg-dark\">" +
                "<div style=\"margin-top:15%;\">\n" +
                "      \n" +
                "      <div class=\"text-center\">" +
                "<h1 class=\"text-white \">Witaj w wyszukiwarce stacji rowerowych. </h1>" +
                "<h2 class=\"text-white \">Wczytaj plik Xml do bazy danych. </h2>" +
                "<form action=\"Welcome\" method=\"post\" enctype=\"multipart/form-data\">" +
                "<div class=\"row justify-content-md-center\"> " +
                "<input type=\"file\" class=\"col-3 form-control\" name=\"userFile\" style=\"\n" +
                "text-align: center !important;\n" +
                "\"><button class=\"btn btn-secondary btn-lg\" type=\"submit\">Załaduj plik</button></div>" +

                "</form>" +
                "</div>" +
                "</div>" +
                "</body>" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(WelcomeServlet.class);

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

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
            writer.println("<!DOCTYPE html>" +
                    "<html>" +
                    "<head>" +
                    "<link rel=\"stylesheet\" " +
                    "href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css\"" +
                    " integrity=\"sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M\"" +
                    " crossorigin=\"anonymous\">\n" +
                    "<script src=\"https://code.jquery.com/jquery-3.1.1.slim.min.js\" " +
                    "integrity=\"sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n\"" +
                    " crossorigin=\"anonymous\"></script>\n" +
                    "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js\"" +
                    " integrity=\"sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb\" " +
                    "crossorigin=\"anonymous\"></script>\n" +
                    "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js\" " +
                    "integrity=\"sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn\" " +
                    "crossorigin=\"anonymous\"></script>" +
                    "</head>" +
                    "<body class=\"bg-dark\">" +
                    "<div style=\"margin-top:15%;\">\n" +
                    "      \n" +
                    "      <div class=\"text-center\">" +
                    "<h1 class=\"text-white\">Twoj plik zostal wczytany </h1>" +
                    "<form action=\"Menu\" method=\"get\">" +
                    "<button class=\"btn btn-secondary btn-lg\" type=\"submit\" />Przejdz do menu</button>" +
                    "</div>" +
                    "</div>" +
                    "</body>" +
                    "</html>");
        } catch (IOException | ServletException e) {
            logger.warn("bład wczytania pliku");
        }
    }
}
