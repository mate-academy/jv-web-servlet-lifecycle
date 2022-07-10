package mate.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mate.dao.MyCoolResource;

import java.io.IOException;

public class IndexController extends HttpServlet {
    private final String path = "/WEB-INF/views/index.jsp";
    private MyCoolResource myResource;
    //TODO: implement

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/items").forward(req, resp);
//        resp.sendRedirect("/items");
    }
}
