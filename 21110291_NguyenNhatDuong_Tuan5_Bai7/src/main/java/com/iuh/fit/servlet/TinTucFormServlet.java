package com.iuh.fit.servlet;

import com.iuh.fit.dao.TinTucDao;
import com.iuh.fit.daoImpl.DanhSachTinTucQuanLy;
import com.iuh.fit.entities.DanhMuc;
import com.iuh.fit.entities.TinTuc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tintuc-form")
public class TinTucFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        String link = request.getParameter("link");
//        String parten = "^http://.*$";
//        if (!link.matches(parten)) {
//            request.setAttribute("errorMessage", "Liên kết không hợp lệ");
//            request.getRequestDispatcher("/views/tintuc/TinTucForm.jsp").forward(request, response);
//            return;
//        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        TinTucDao tinTucDao = new DanhSachTinTucQuanLy();

        String title = request.getParameter("title");
        String link = request.getParameter("link");
        String content = request.getParameter("content");
        int categoryId = Integer.parseInt(request.getParameter("category"));

        String parten = "^[(https://)|(http://)].*$";
        if (!link.matches(parten)) {
            request.setAttribute("errorMessage", "Liên kết không hợp lệ");
            request.getRequestDispatcher("/views/tintuc/TinTucForm.jsp").forward(request, response);
            return;

        }else {
            DanhMuc danhMuc = new DanhMuc(categoryId);
            tinTucDao.themTinTuc(new TinTuc(title, content, link, danhMuc));
            request.setAttribute("listTinTuc", tinTucDao.getAll());
            request.getRequestDispatcher("/views/tintuc/DanhSachTinTuc.jsp").forward(request, response);
            return;
        }
    }
}
