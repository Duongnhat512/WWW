package com.iuh.fit.servlet;

import com.iuh.fit.dao.DanhMucDao;
import com.iuh.fit.dao.TinTucDao;
import com.iuh.fit.daoImpl.DanhMucImpl;
import com.iuh.fit.daoImpl.DanhSachTinTucQuanLy;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/danhsachtintuc")
public class DanhSachTinTucServlet extends HttpServlet {
    private TinTucDao tinTucDao = new DanhSachTinTucQuanLy();
    private DanhMucDao danhMucDao = new DanhMucImpl();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action") != null ? req.getParameter("action") : "";
        switch (action) {
            case "list":{
                showList(req, resp);
                break;
            }
            case "add": {
                showTinTucForm(req, resp);
                break;
            }
            case "manage":{
                showQuanLyForm(req, resp);
                break;
            }
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listTinTuc", tinTucDao.getAll());
        req.getRequestDispatcher("/views/tintuc/DanhSachTinTuc.jsp").forward(req, resp);
    }

    private void showTinTucForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhmucs", danhMucDao.getAll());
        req.getRequestDispatcher("/views/tintuc/TinTucForm.jsp").forward(req, resp);
    }

    private void showQuanLyForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listTinTuc", tinTucDao.getAll());
        req.getRequestDispatcher("/views/tintuc/QuanLyForm.jsp").forward(req, resp);
    }
}
