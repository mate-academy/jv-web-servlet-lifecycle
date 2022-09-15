package mate.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

@WebServlet(urlPatterns = "/index")
public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write(new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z")
                        .format(System.currentTimeMillis()));
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        myResource.close();
    }
}
