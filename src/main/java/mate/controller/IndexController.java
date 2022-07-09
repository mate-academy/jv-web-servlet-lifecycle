package mate.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init() throws ServletException {
        super.init();
        myResource = MyCoolResource.openResource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String dateAndTime = LocalDate.now() + " " + LocalTime.now();
        myResource.write("Current date and time is: " + dateAndTime);
        req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        myResource.close();
    }
}
