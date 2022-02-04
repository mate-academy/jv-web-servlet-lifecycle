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

@WebServlet(urlPatterns = "/index")
public class IndexController extends HttpServlet {
    private static final String DATETIME_PATTERN = "HH:mm:ss MMM dd yyyy";
    private static final String RESOURCE_WRITTEN = "WEB-INF/views/resourceWrittenOk.jsp";
    private MyCoolResource myResource;

    @Override
    public void init() {
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write(
                LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATETIME_PATTERN))
        );
        req.getRequestDispatcher(RESOURCE_WRITTEN).forward(req, resp);
    }

    @Override
    public void destroy() {
        myResource.close();
    }
}
