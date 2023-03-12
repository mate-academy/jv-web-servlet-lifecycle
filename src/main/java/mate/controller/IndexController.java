package mate.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mate.dao.MyCoolResource;

import java.io.IOException;

public class IndexController extends HttpServlet {
    private MyCoolResource myResource;

    @Override
    public void init() throws ServletException {

        System.out.println("Всім ку");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("Добрий вечір");
        req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req,resp);
    }

    @Override
    public void destroy() {
        myResource.close();
    }
}
