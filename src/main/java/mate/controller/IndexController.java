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
        super.init();
        myResource = MyCoolResource.openResource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String currentDateTime = LocalDateTime.now().toString();
        myResource.write(currentDateTime);
        req.setAttribute("Date",currentDateTime);
        req.getRequestDispatcher("/WEB-INF/views/info_page.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        myResource.close();
        super.destroy();
    }
}

