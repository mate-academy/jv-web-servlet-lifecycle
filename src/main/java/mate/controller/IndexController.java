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
    public void init() throws ServletException {
        myResource = MyCoolResource.openResource();
        super.init();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        myResource.write(localDateTime.toString());
        req.getRequestDispatcher("/WEB-INF/views/page.jsp").include(req, resp);
    }

    @Override
    public void destroy() {
        myResource.close();
        super.destroy();
    }
}
