package com.jsp.chap04;

import com.jsp.entity.Dancer;
import com.jsp.repository.DancerRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dancer/delete")
public class DeleteServlet extends HttpServlet {
    DancerRepository dr = new DancerRepository();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        dr.delete(name);
        List<Dancer> dl = dr.findAll();
        req.setAttribute("dl", dl);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/chap04/dancer/list.jsp");
        rd.forward(req, resp);
    }
}
