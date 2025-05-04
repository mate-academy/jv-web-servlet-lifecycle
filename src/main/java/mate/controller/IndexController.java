package mate.controller;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        myResource = MyCoolResource.openResource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write(LocalDate.now().toString());
        System.out.println("doGet was calling");
        req.getRequestDispatcher("/WEB_INF/views/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        myResource.close();
    }
}
