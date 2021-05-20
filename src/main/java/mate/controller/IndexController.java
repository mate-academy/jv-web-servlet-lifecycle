package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

@WebServlet(urlPatterns = "/")
public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init() {
        myResource = MyCoolResource.openResource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
        String currentDateTime =
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("d MMM yyyy HH:mm:ss"));
        req.setAttribute("date", currentDateTime);
        myResource.write(currentDateTime);
        req.getRequestDispatcher("WEB-INF/views/info.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        myResource.close();
    }
}
