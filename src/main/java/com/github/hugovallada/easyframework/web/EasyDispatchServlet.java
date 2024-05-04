package com.github.hugovallada.easyframework.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EasyDispatchServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (request.getRequestURL().toString().endsWith("/favicon.ico")) {
            return;
        }
        System.out.println("URL = " + request.getRequestURL().toString());
        PrintWriter out = new PrintWriter(response.getWriter());
        out.println("Hello World for EasyFramework");
        out.close();
    }

}
