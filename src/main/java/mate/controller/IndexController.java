package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private static final String DATE_TIME_PATTERN = "dd-MM-yyyy";
    private MyCoolResource myResource;

    @Override
    public void init() throws ServletException {
        super.init();
        myResource = MyCoolResource.openResource();
        //        myResource = (MyCoolResource) getServletContext().getAttribute("myResource");
        //        if (myResource == null) {
        //            throw new UnavailableException("Couldn't get resource");
        //        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        String actualDate = localDateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
        myResource.write(actualDate);
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        myResource.close();
    }
}
