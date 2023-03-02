package mate.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mate.dao.MyCoolResource;

import java.io.IOException;
import java.time.LocalDate;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init() throws ServletException {
        myResource = MyCoolResource.openResource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        myResource.write(LocalDate.now().toString());
        req.getRequestDispatcher("WEB-INF/views/index.jsp").include(req, resp);
    }

    @Override
    public void destroy() {
        myResource.close();
    }
}
