package com.iuh.fit.servlet;

import com.iuh.fit.beans.ItemCart;
import com.iuh.fit.dao.DaoProduct;
import com.iuh.fit.daoImpl.DaoProductImpl;
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

@WebServlet(name = "CartItemController", urlPatterns = {"/cart", "/cart*"})
public class CartItemController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;

    private DaoProduct daoProduct;

    public CartItemController() {
        System.out.println(dataSource);
    }

    @Override
    public void init(ServletConfig config){
        try {
            daoProduct = new DaoProductImpl(this.dataSource);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") != null ? request.getParameter("action") : "";

        switch (action) {
            case "buy":
                doGetBuy(request, response);
                break;
            case "remove":
                doGetRemoveItem(request, response);
                break;
            default:
                doGetDisplayCart(request, response);
                break;
        }
    }

    private void doGetDisplayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/cart/index.jsp").forward(request, response);
    }

    private void doGetRemoveItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<ItemCart> cart = (List<ItemCart>) session.getAttribute("cart");
        int index = isProductExisting(Integer.parseInt(request.getParameter("id")), cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        response.sendRedirect("cart");
    }

    private void doGetBuy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<ItemCart> cart = null;
        if (session.getAttribute("cart") == null) {
            cart = new ArrayList<ItemCart>();
        }else {
            cart = (List<ItemCart>) session.getAttribute("cart");
        }
        int index = isProductExisting(Integer.parseInt(request.getParameter("id")), cart);
        if (index == -1) {
            cart.add(new ItemCart(daoProduct.getById(Integer.parseInt(request.getParameter("id"))), 1));
        } else {
            int quantity = cart.get(index).getQuantity() + 1;
            cart.get(index).setQuantity(quantity);
        }
        session.setAttribute("cart", cart);
        response.sendRedirect("cart");
    }

    private int isProductExisting(int id, List<ItemCart> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == id) {
                return i;
            }
        }
        return -1;
    }
}