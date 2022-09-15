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

    public IndexController() {
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write("Date & time now:");
        myResource.write(LocalDateTime.now().toString());
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").include(req, resp);
    }

    @Override
    public void destroy() {
        myResource.close();
    }
}
