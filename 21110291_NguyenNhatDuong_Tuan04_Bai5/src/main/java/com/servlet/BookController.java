package com.servlet;

import com.bean.Book;
import com.dao.BookDao;
import com.daoImpl.BookDaoImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author Nguyen Nhat Duong
 * @datetime 22/09/2024
 */

@WebServlet(urlPatterns ={"/book", "/book*"})
public class BookController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(name = "jdbc/bookstore")
    private DataSource dataSource;

    private BookDao bookDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try{
            System.out.println(dataSource.getConnection());
        }catch (Exception e){
            e.printStackTrace();
        }

        bookDao = new BookDaoImpl(dataSource);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Book book = new Book("Sổ tay viết văn", "Tô Hoài", 99000, 10, "img1.png");
//        Book book1 = new Book("Nhật ký ma cà rồng - CƠN THỊNH NỘ", "Belveth", 48000, 10, "img2.png");
//        Book book2 = new Book("Billy và Beth - 3 bí quyết của người thành đạt", "Tune'Farm", 52000, 10, "img3.png");
//        Book book3 = new Book("Bí ẩn một cái tên - Dịch giả: Nguễn Hồng Dung", "TunaBigC", 83000, 10, "img4.png");
//        Book book4 = new Book("Kẻ trộm sách", "MarkusZusak", 71000, 10, "img5.png");
//        Book book5 = new Book("Cơm & Phở", "Xuân Sách", 120000, 10, "img6.png");
//
//        bookDao.add(book);
//        bookDao.add(book1);
//        bookDao.add(book2);
//        bookDao.add(book3);
//        bookDao.add(book4);
//        bookDao.add(book5);
//
//        System.out.println(bookDao.findAll());

        request.setAttribute("books", bookDao.findAll());
        request.getRequestDispatcher("./views/book/index.jsp").forward(request, response);
    }
}
