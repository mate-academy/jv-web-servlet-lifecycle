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
    private String time = LocalDateTime.now().toString();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        init();
        myResource.write(time);
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
        destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void destroy() {
        super.destroy();
        myResource.close();
    }
}
