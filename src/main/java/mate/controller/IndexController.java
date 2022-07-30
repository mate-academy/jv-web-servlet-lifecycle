package mate.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        myResource = MyCoolResource.openResource();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Date dateNow = new Date();
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        myResource.write(simpleDateFormat.format(dateNow));
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }

    public void destroy() {
        myResource.close();
    }
}
