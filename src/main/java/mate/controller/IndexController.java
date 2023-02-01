package mate.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mate.dao.MyCoolResource;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/index")
public class IndexController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write("Current date is: " + LocalDateTime.now());
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }

    private MyCoolResource myResource;

    @Override
    public void init() throws ServletException {
        super.init();
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void destroy() {
        myResource.close();
        super.destroy();
    }
}
