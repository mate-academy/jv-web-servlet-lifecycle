package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.RequestDispatcher;
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
        myResource = MyCoolResource.openResource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String currentDateTime = LocalDateTime.now().toString();
        String viewPage = "/WEB-INF/views/index.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
        dispatcher.forward(req, resp);
        myResource.write(currentDateTime);
    }

    @Override
    public void destroy() {
        myResource.close();
    }
}
