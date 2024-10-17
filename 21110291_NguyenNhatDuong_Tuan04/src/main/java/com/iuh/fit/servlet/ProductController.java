package com.iuh.fit.servlet;

import com.iuh.fit.beans.Product;
import com.iuh.fit.dao.DaoProduct;
import com.iuh.fit.daoImpl.DaoProductImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "ProductController", urlPatterns = {"/product", "/product*"})
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(name = "jdbc/TestDB")
    private DataSource dataSource;

    private DaoProduct daoProduct;

    public ProductController() {
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            System.out.println(this.dataSource.getConnection());
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        daoProduct = new DaoProductImpl(this.dataSource);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Product p1 = new Product("Product 1", 1000, "image1.png");
//        Product p2 = new Product("Product 2", 2000, "image2.png");
//        Product p3 = new Product("Product 3", 3000, "image3.png");
//        Product p4 = new Product("Product 4", 4000, "image4.png");
//        Product p5 = new Product("Product 5", 5000, "image5.png");
//
//        daoProduct.addProduct(p1);
//        daoProduct.addProduct(p2);
//        daoProduct.addProduct(p3);
//        daoProduct.addProduct(p4);
//        daoProduct.addProduct(p5);
        request.setAttribute("products", daoProduct.findAll());
        request.getRequestDispatcher("./views/product/index.jsp").forward(request, response);

    }
}
