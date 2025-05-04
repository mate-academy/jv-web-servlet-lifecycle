package mate.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private static final String CURRENT_DATE = "WEB-INF/views/index.jsp";
    private MyCoolResource myResource;

    @Override
    public void init() throws ServletException {
        myResource = MyCoolResource.openResource();
        System.out.println("MyCoolResource was initialized");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write(CURRENT_DATE);
        req.getRequestDispatcher(CURRENT_DATE).forward(req, resp);
        System.out.println("MyCoolResource was called");
    }

    @Override
    public void destroy() {
        myResource.close();
        System.out.println("MyCoolResource was closed");
    }
}
