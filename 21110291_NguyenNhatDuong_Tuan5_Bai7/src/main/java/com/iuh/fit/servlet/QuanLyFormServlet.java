package com.iuh.fit.servlet;

import com.iuh.fit.dao.TinTucDao;
import com.iuh.fit.daoImpl.DanhSachTinTucQuanLy;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/quanly-form")
public class QuanLyFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int maTT = Integer.parseInt(request.getParameter("id"));

        TinTucDao tinTucDao = new DanhSachTinTucQuanLy();
        tinTucDao.xoaTinTuc(maTT);

        request.setAttribute("listTinTuc", tinTucDao.getAll());
        request.getRequestDispatcher("/views/tintuc/QuanLyForm.jsp").forward(request, response);
    }
}
