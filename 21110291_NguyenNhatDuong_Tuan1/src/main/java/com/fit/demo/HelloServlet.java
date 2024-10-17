package com.fit.demo;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Hello </h1>");
        out.println("</body></html>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "admin".equals(password)) {
            // Login successful
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1> Login successful </h1>");
            out.println("</body></html>");
        } else {
            // Login failed
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1> Login failed </h1>");
            out.println("</body></html>");
        }

        Writer out = response.getWriter();
        out.write("Username: " + username + " Password: " + password);


    }
    public void destroy() {
    }
}