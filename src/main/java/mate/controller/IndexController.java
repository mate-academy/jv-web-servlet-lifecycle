package mate.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;
import java.io.IOException;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;
    //TODO: implement
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("data", myResource);
        myResource.write("1");
        myResource.write("2");
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);

    }

    @Override
    public void destroy() {
        myResource.close();
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) {
        myResource = MyCoolResource.openResource();
    }
}
