package infoshareKurs.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet("/portal/bikeSearch")
@MultipartConfig
public class BikeSearchServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/bikeSearchGET.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(BikeSearchServlet.class);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/bikeSearchPOST.jsp");

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

        } catch (IOException | ServletException e) {
            logger.warn("bład wczytania pliku");
        }
        requestDispatcher.forward(req, resp);
    }
}
