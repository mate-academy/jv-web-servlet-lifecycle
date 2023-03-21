package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        req.getRequestDispatcher("/webapp/views/index.jsp").forward(req, resp);
        myResource.write(LocalDateTime.now().toString());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        super.doDelete(req, resp);
        myResource.close();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        myResource = MyCoolResource.openResource();
    }
}
