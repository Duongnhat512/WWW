package com.fit.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "registerForm", value = "/register-form")
public class RegisterForm extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String firstName=request.getParameter("firstName");
        String email=request.getParameter("email");
        String facebook=request.getParameter("facebook");
        String shortbio=request.getParameter("shortbio");
        String html="<br>" + "<html>"
                + "<head>" + "<title>Result Page</title>"
                + "</head>" + "<body>"
                + "First Name: "+ firstName +"<br>"
                + "Email: "+ email +"<br> Facebook URL: "+ facebook +"<br>"
                + "Short Bio: "+ shortbio +"<br>"
                + "</body>" + "</html>";
        out.println(html);
    }

//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//        PrintWriter out=response.getWriter();
//        String firstName=request.getParameter("firstName");
//        String email=request.getParameter("email");
//        String facebook=request.getParameter("facebook");
//        String shortbio=request.getParameter("shortbio");
//        String html="<br>" + "<html>"
//                + "<head>" + "<title>Result Page</title>"
//                + "</head>" + "<body>"
//                + "First Name: "+ firstName +"<br>"
//                + "Email: "+ email +"<br> Facebook URL: "+ facebook +"<br>"
//                + "Short Bio: "+ shortbio +"<br>"
//                + "</body>" + "</html>";
//        out.println(html);
//    }

}
