package com.longph31848.assignment.controller;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.KhachHang;
import com.longph31848.assignment.repository.KhachHangService;
import com.longph31848.assignment.repository.impl.KhachHangServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/khach-hang")
public class KhachHangController extends HttpServlet {

    private Connection connection;
    private KhachHangService service;
    private List<KhachHang> list;

    @Override
    public void init() {
        try {
            connection = DataBaseConnection.getConnection();
            service = new KhachHangServiceImpl();
            list = service.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("khachhanglist", list);
        req.getRequestDispatcher("/views/khachhang/khachhang.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
