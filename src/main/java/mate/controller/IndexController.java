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
    public void init() {
        myResource = MyCoolResource.openResource();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String currentDateTime = LocalDateTime.now().toString();

        request.setAttribute("currentDateTime", currentDateTime);
        request.getRequestDispatcher("/WEB-INF/views/display.jsp")
                .forward(request, response);
    }

    @Override
    public void destroy() {
        if (myResource != null) {
            myResource.close();
        }
    }
}

