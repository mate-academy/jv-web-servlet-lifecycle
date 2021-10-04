package mate.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/items")
public class ItemsController extends HttpServlet {

    static {
        System.out.println("static ItemsController");
    }

    public ItemsController() {
        System.out.println("constructor ItemsController");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("method doGet ItemsController");
        //req.getRequestDispatcher("WEB-INF/views/items.jsp").forward(req, resp);
        //req.getRequestDispatcher("/index").forward(req, resp);
        //resp.sendRedirect("/index");
        req.getRequestDispatcher("WEB-INF/views/index.jsp").include(req, resp);
        req.getRequestDispatcher("WEB-INF/views/items.jsp").include(req, resp);
    }
}
