package com.servlet;

import com.dao.BookDao;
import com.daoImpl.BookDaoImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author Nguyen Nhat Duong
 * @datetime 22/09/2024
 */

@WebServlet(urlPatterns ={"/details", "/details*"})
public class BookDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(name = "jdbc/bookstore")
    private DataSource dataSource;

    private BookDao bookDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookDao = new BookDaoImpl(dataSource);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("book", bookDao.findById(id));
        request.getRequestDispatcher("./views/book/details.jsp").forward(request, response);
    }
}
