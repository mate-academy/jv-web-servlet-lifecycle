package mate.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        myResource = MyCoolResource.openResource();
    }
}
