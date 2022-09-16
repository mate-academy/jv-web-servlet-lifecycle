package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;
    private LocalDateTime localDateTime;

    @Override
    public void init(ServletConfig config) throws ServletException {
        myResource = MyCoolResource.openResource();
        localDateTime = LocalDateTime.now();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        myResource.write(localDateTime.toString());
        request.setAttribute("date", localDateTime.toString());
        request.getRequestDispatcher("/WEB-INF/views/index.jsp")
                .forward(request, response);
    }

    @Override
    public void destroy() {
        myResource.close();
    }
}
