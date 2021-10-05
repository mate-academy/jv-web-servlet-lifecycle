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

    static {
        System.out.println("Class IndexController was loaded");
    }

    public IndexController() {
        System.out.println("Instance of IndexController was created");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Method init() was called");
        super.init();
        myResource = MyCoolResource.openResource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("Method doGet() was called");
        myResource.write(LocalDateTime.now().toString());
        req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("Method destroy() was called");
        super.destroy();
        myResource.close();
    }
}
