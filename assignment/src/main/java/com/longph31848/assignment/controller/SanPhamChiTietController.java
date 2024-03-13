package com.longph31848.assignment.controller;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.SanPham;
import com.longph31848.assignment.entity.SanPhamChiTiet;
import com.longph31848.assignment.repository.SanPhamChiTietService;
import com.longph31848.assignment.repository.SanPhamService;
import com.longph31848.assignment.repository.impl.SanPhamChiTietImpl;
import com.longph31848.assignment.repository.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/san-pham-chi-tiet")
public class SanPhamChiTietController extends HttpServlet {

    private Connection connection;
    private SanPhamChiTietService service;
    private List<SanPhamChiTiet> list;

    @Override
    public void init() {
        try {
            connection = DataBaseConnection.getConnection();
            service = new SanPhamChiTietImpl();
            list = service.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sanphamchitietlist", list);
        req.getRequestDispatcher("/views/sanphamchitiet/sanphamchitiet.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
