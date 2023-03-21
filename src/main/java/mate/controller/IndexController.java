package mate.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;
import mate.service.MyCoolMoment;

@WebServlet
public class IndexController extends HttpServlet {
    private MyCoolResource myResource;
    private final MyCoolMoment myCoolMoment;
    //TODO: implement

    public IndexController() {
        myCoolMoment = new MyCoolMoment();
    }

    @Override
    public void init() throws ServletException {
        myResource = MyCoolResource.openResource();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String moment = myCoolMoment.getFormatter();
        myResource.write(moment);
        req.getSession().setAttribute("moment", moment);
        req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        myResource.close();
        super.destroy();
    }
}
