package mate.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("doGet was called");
        String date = LocalDate.now().toString();
        String time = LocalTime.now().toString();
        myResource.write("date is " + date);
        myResource.write("time is " + time);
        req.setAttribute("message", myResource.toString());
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init was called");
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void destroy() {
        myResource.close();
    }
}
