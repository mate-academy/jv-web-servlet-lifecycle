package mate.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init() throws ServletException {
        myResource = MyCoolResource.openResource();
        System.out.println("MyCoolResource was initialized");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write(LocalDate.now().toString());
        req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req, resp);
        System.out.println("MyCoolResource was called");
    }

    @Override
    public void destroy() {
        myResource.close();
        System.out.println("MyCoolResource was closed");
    }
}
