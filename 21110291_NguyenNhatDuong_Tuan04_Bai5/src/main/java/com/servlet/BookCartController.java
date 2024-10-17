package com.servlet;

import com.bean.Book;
import com.bean.BookCart;
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
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nguyen Nhat Duong
 * @datetime 22/09/2024
 */

@WebServlet(urlPatterns ={"/cart", "/cart*"})
public class BookCartController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(name = "jdbc/bookstore")
    private DataSource dataSource;

    private BookDao bookDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookDao = new BookDaoImpl(dataSource);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") != null ? request.getParameter("action") : "";

        switch (action){
            case "add":
                doGetAdd(request, response);
                break;
            case "delete":
                doGetDelete(request, response);
                break;
            default:
                doGetDisplay(request, response);
                break;
        }
    }

    protected void doGetDisplay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./views/cart/index.jsp").forward(request, response);
    }

    protected void doGetDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<BookCart> cart = (List<BookCart>) session.getAttribute("cart");

        int index = isProductExisting(Integer.parseInt(request.getParameter("id")), cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        response.sendRedirect("cart");
    }

    protected void doGetAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<BookCart> cart = null;

        if(session.getAttribute("cart") == null){
            cart = new ArrayList<BookCart>();
        }else {
            cart = (List<BookCart>) session.getAttribute("cart");
        }

        int index = isProductExisting(Integer.parseInt(request.getParameter("id")), cart);
        Book book = bookDao.findById(Integer.parseInt(request.getParameter("id")));
        if(index == -1){
            cart.add(new BookCart(book, 1));
        }else {
            int quantity = cart.get(index).getQuantity() + 1;
            cart.get(index).setQuantity(quantity);
        }
        book.setQuantity(book.getQuantity() - 1);

        session.setAttribute("cart", cart);
        response.sendRedirect("cart");
    }

    private int isProductExisting(int id, List<BookCart> cart){
        for(int i = 0; i < cart.size(); i++){
            if(cart.get(i).getBook().getId() == id){
                return i;
            }
        }
        return -1;
    }



}
