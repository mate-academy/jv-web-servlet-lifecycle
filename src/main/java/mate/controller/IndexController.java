package mate.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import mate.dao.MyCoolResource;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init() {
        myResource = MyCoolResource.openResource();
    }

}
