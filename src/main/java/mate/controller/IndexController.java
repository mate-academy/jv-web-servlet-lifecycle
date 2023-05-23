package mate.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

@WebServlet(urlPatterns = {"/", "/index"})
public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void destroy() {
        myResource.close();
        System.out.println("Destroy method was called ...");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Init method was called ...");
        myResource = MyCoolResource.openResource();
        myResource.write("message1");
        myResource.write("message2");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("doGet method was called ...");
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        myResource.write(date.toString());
        myResource.write(time.toString());
        req.setAttribute("date", date.toString());
        req.setAttribute("time", time.toString());
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }
}
