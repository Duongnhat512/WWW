package com.iuh.se.controllers;

import com.iuh.se.dao.DienThoaiDAO;
import com.iuh.se.daoImpl.DienThoaiDAOImpl;
import com.iuh.se.entities.DienThoai;
import com.iuh.se.entities.NhaCungCap;
import com.iuh.se.util.EntityManagerFactoryUtil;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/phone")
public class DienThoaiController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EntityManagerFactoryUtil entityManagerFactoryUtil;
    private DienThoaiDAO dienThoaiDAO;

    public DienThoaiController() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
        this.entityManagerFactoryUtil = new EntityManagerFactoryUtil();
        this.dienThoaiDAO = new DienThoaiDAOImpl(this.entityManagerFactoryUtil.getEntityManager());
    }

    public void destroy() {
        this.entityManagerFactoryUtil.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") != null ? request.getParameter("action") : "";

        switch (action) {
            case "new":
                showDienThoaiForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteDienThoai(request, response);
                break;
            default:
                listDienThoai(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") != null ? request.getParameter("action") : "";

        switch (action) {
            case "insert":
                insertDienThoai(request, response);
                break;
            case "update":
                updateDienThoai(request, response);
                break;
            default:
                listDienThoai(request, response);
                break;
        }
    }

    private void listDienThoai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dienThoais", this.dienThoaiDAO.findAllDT());
        request.getRequestDispatcher("/views/phone/list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dienThoai", this.dienThoaiDAO.findDTById(Integer.parseInt(request.getParameter("txtId"))));
        request.getRequestDispatcher("/views/phone/edit.jsp").forward(request, response);
    }

    private void deleteDienThoai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.dienThoaiDAO.delete(Integer.parseInt(request.getParameter("txtId")));
        response.sendRedirect("phone");
    }

    private void showDienThoaiForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/phone/add.jsp").forward(request, response);
    }

    private void updateDienThoai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DienThoai dienThoai = new DienThoai();
        dienThoai.setMaDT(Integer.parseInt(request.getParameter("txtId")));
        dienThoai.setTenDT(request.getParameter("txtTenDT"));
        dienThoai.setNamSanXuat(Integer.parseInt(request.getParameter("txtNamSanXuat")));
        dienThoai.setCauHinh(request.getParameter("txtCauHinh"));
        dienThoai.setNhaCC(new NhaCungCap(Integer.parseInt(request.getParameter("txtMaNCC"))));

        this.dienThoaiDAO.update(dienThoai);
        response.sendRedirect("phone");
    }

    private void insertDienThoai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DienThoai dienThoai = new DienThoai();
        dienThoai.setTenDT(request.getParameter("txtTenDT"));
        dienThoai.setNamSanXuat(Integer.parseInt(request.getParameter("txtNamSanXuat")));
        dienThoai.setCauHinh(request.getParameter("txtCauHinh"));
        dienThoai.setNhaCC(new NhaCungCap(Integer.parseInt(request.getParameter("txtMaNCC"))));

        this.dienThoaiDAO.save(dienThoai);
        response.sendRedirect("phone");
    }
}
