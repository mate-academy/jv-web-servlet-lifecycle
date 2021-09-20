package mate.controller;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

@WebServlet(urlPatterns = "/info")
public class MyCoolResourceController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init() throws ServletException {
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void destroy() {
        myResource.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String todayDate = LocalDate.now().toString();
        myResource.write(todayDate);
        req.setAttribute("todayDate", todayDate);
        req.getRequestDispatcher("/WEB-INF/views/myCoolResource.jsp").forward(req, resp);
    }
}
