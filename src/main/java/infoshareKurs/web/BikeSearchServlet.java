package infoshareKurs.web;

import org.apache.commons.io.FileUtils;
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
import java.net.URL;

@WebServlet("/portal/bikeSearch")
@MultipartConfig
public class BikeSearchServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/bikeSearchGET.jsp");


        String fromFile = "https://nextbike.net/maps/nextbike-live.xml";
        String toFile = "data/nextbike-live.xml";

        try {
            FileUtils.copyURLToFile(new URL(fromFile), new File(toFile), 10000, 10000);

        } catch (IOException e) {
            e.printStackTrace();

        }

        requestDispatcher.forward(req, resp);
    }
}
