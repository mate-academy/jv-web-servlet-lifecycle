package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

@WebServlet(urlPatterns = "/write")
public class WriteController extends HttpServlet {
    private static final String CONFIRMATION_FILE_PATH = "/WEB-INF/views/confirmation.jsp";
    private MyCoolResource myResource;

    @Override
    public void init() throws ServletException {
        myResource = MyCoolResource.openResource();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write(LocalDateTime.now().toString());
        req.getRequestDispatcher(CONFIRMATION_FILE_PATH).forward(req, resp);
    }

    @Override
    public void destroy() {
        myResource.close();
        super.destroy();
    }
}
