package com.fit.src.servlet;

import com.fit.src.entities.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "RegistrationForm", value = "/registration-form")
public class RegistrationForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String email = request.getParameter("email");
        String mobileNum = request.getParameter("mobileNum");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String pinCode = request.getParameter("pinCode");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String [] hobbies = request.getParameterValues("hobbies");
        String course = request.getParameter("course");

        String birthDate = day + " "+ month + " "+ year;

        Student sv = new Student();
        sv.setFname(fname);
        sv.setLname(lname);
        sv.setBirthDate(LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)));
        sv.setEmail(email);
        sv.setGender(gender);
        sv.setHobbies(List.of(hobbies));

        request.setAttribute("student", sv);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Submitform.jsp");
        requestDispatcher.forward(request, response);


    }
}
