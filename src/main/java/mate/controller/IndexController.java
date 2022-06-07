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

    //TODO: implement
    @Override
    public void init()
            throws ServletException {
        myResource = MyCoolResource.openResource();
        super.init();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write(String.valueOf(LocalDateTime.now()));
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        myResource.close();
        super.destroy();
    }
}
