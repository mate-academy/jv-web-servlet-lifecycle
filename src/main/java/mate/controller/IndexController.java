package mate.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private static final String URL_TO_INDEX = "WEB-INF" + File.separator
                                             + "views" + File.separator + "index.jsp";
    private MyCoolResource myResource;
    //TODO: implement

    @Override
    public void init() throws ServletException {
        super.init();
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myResource.write(String.valueOf(LocalDate.now()));
        req.getRequestDispatcher(URL_TO_INDEX).include(req, resp);
        myResource.write(String.valueOf(LocalTime.now()));
        req.getRequestDispatcher(URL_TO_INDEX).include(req, resp);
    }

    @Override
    public void destroy() {
        myResource.close();
        super.destroy();
    }
}
