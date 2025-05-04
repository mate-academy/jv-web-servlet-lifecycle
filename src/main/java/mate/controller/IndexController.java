package mate.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
        this.myResource = MyCoolResource.openResource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write(LocalDateTime.now().toString());
        PrintWriter out = resp.getWriter();
        myResource.getStringList().forEach(out::println);
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").include(req, resp);
    }

    @Override
    public void destroy() {
        myResource.close();
    }
}
