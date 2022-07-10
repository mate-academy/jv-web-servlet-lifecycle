package mate.controller;

import mate.dao.MyCoolResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ItemsController extends HttpServlet {
    private final String path = "/WEB-INF/views/items.jsp";
    private MyCoolResource myResource;
    //TODO: implement

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("items controller was called");
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
