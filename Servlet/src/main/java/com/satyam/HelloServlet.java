package com.satyam;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//calls the method service when request is sent
public class HelloServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("In service");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<i>Hello</i> World");

    }

}
