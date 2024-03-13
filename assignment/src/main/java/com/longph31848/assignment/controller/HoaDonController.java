package com.longph31848.assignment.controller;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.HoaDon;
import com.longph31848.assignment.entity.SanPham;
import com.longph31848.assignment.repository.HoaDonService;
import com.longph31848.assignment.repository.SanPhamService;
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

@WebServlet("/hoa-don")
public class HoaDonController extends HttpServlet {

    private Connection connection;
    private HoaDonService service;
    private List<HoaDon> list;

    @Override
    public void init() {
        try {
            connection = DataBaseConnection.getConnection();
            service = new HoaDonServiceImpl();
            list = service.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("hoadonlist", list);
        req.getRequestDispatcher("/views/hoadon/hoadon.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
