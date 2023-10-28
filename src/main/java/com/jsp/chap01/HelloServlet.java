package com.jsp.chap01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

// 역할: HTTP요청 응답 처리에서 필요한 공통적인 부분을 쉽게 해결 해주는 자바API
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    public HelloServlet() {
        System.out.println("\n\n\n헬로 서블릿 작동 시작!\n\n\n");
    }

    // 파싱된 요청 정보를 얻는 법


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 클라이언트의 요청 방식
        String method = req.getMethod();

        // 요청 URL
        String requestURI = req.getRequestURI();

        // 요청 Header 읽기
        String header = req.getHeader("Cache-Control");

        System.out.println("method = " + method);
        System.out.println("requestURI = " + requestURI);
        System.out.println("header = " + header);

        // Query parameter Read
        String keyword = req.getParameter("keyword");
        System.out.println("keyword = " + keyword);
        String age = req.getParameter("age");
        System.out.println("age = " + age);

        // 응답 메시지에 HTML문서 생성해서 응답하기
        // keyword님은 XXXX년생 입니다.

        // 비지니스 로직 작성
        // 출생년도 구하기
        int year = LocalDateTime.now().getYear();
        int birthYear = year - Integer.parseInt(age) + 1;

        //html 생성
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        //html을 작성할 펜 같은거
        PrintWriter writer = resp.getWriter();
        writer.write("<!DOCTYPE html>\n");
        writer.write("<html>\n");
        writer.write("<head>\n");
        writer.write("</head>\n");
        writer.write("<body>\n");
        writer.write("<h1>\n");
        writer.write(String.format("%s님은 %d년생 입니다.", keyword, birthYear));
        writer.write("</h1>\n");
        writer.write("</body>\n");
        writer.write("</html>\n");
        writer.flush();
        writer.close();
    }
}
