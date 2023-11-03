package com.jsp.chap04;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/hahahoho")
public class TestViewServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //@WebServlet("/hahahoho")로 받은 경로를 내부적으로 보안폴더(WEB-INF)에 있는 jsp를 열어준다 - 포워딩
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/test.jsp");
        rd.forward(req, resp);
    }
}
