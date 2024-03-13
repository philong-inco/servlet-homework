package com.longph31848.assignment.controller;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.HoaDonChiTiet;
import com.longph31848.assignment.entity.SanPham;
import com.longph31848.assignment.repository.HoaDonChiTietService;
import com.longph31848.assignment.repository.HoaDonService;
import com.longph31848.assignment.repository.SanPhamService;
import com.longph31848.assignment.repository.impl.HoaDonChiTietServiceImpl;
import com.longph31848.assignment.repository.impl.HoaDonServiceImpl;
import com.longph31848.assignment.repository.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/hoa-don-chi-tiet")
public class HoaDonChiTietController extends HttpServlet {

    private Connection connection;
    private HoaDonChiTietService service;
    private List<HoaDonChiTiet> list;

    @Override
    public void init() {
        try {
            connection = DataBaseConnection.getConnection();
            service = new HoaDonChiTietServiceImpl();
            list = service.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("hoadonchitietlist", list);
        req.getRequestDispatcher("/views/hoadonchitiet/hoadonchitiet.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
