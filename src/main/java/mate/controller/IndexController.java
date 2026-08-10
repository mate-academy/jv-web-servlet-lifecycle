package mate.controller;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private LocalDate localDate;
    private MyCoolResource myResource;

    //TODO: implement
    @Override
    public void init() throws ServletException {
        myResource = MyCoolResource.openResource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        req.getRequestDispatcher("/WEB-INF/views/lifecycle.jsp").forward(req, resp);
        localDate = LocalDate.now();
        myResource.write(localDate.toString());
    }

    @Override
    public void destroy() {
        myResource.close();
    }
}
