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
    public void init() throws ServletException {
        System.out.println("Init was called");
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        LocalDateTime currentDateTime = LocalDateTime.now();
        myResource.write(currentDateTime.toString());
        System.out.println("Written current date to resource");
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy was called");
        myResource.close();
    }
}
