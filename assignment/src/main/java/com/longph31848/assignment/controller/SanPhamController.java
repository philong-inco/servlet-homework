package com.longph31848.assignment.controller;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.MauSac;
import com.longph31848.assignment.entity.SanPham;
import com.longph31848.assignment.repository.MauSacService;
import com.longph31848.assignment.repository.SanPhamService;
import com.longph31848.assignment.repository.impl.MauSacServiceImpl;
import com.longph31848.assignment.repository.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/san-pham")
public class SanPhamController extends HttpServlet {

    private Connection connection;
    private SanPhamService service;
    private List<SanPham> list;

    @Override
    public void init() {
        try {
            connection = DataBaseConnection.getConnection();
            service = new SanPhamServiceImpl();
            list = service.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sanphamlist", list);
        req.getRequestDispatcher("/views/sanpham/sanpham.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
