package com.longph31848.assignment.controller;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.NhanVien;
import com.longph31848.assignment.entity.SanPham;
import com.longph31848.assignment.repository.NhanVienService;
import com.longph31848.assignment.repository.SanPhamService;
import com.longph31848.assignment.repository.impl.NhanVienServiceImpl;
import com.longph31848.assignment.repository.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/nhan-vien")
public class NhanVienController extends HttpServlet {

    private Connection connection;
    private NhanVienService service;
    private List<NhanVien> list;

    @Override
    public void init() {
        try {
            connection = DataBaseConnection.getConnection();
            service = new NhanVienServiceImpl();
            list = service.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("nhanvienlist", list);
        req.getRequestDispatcher("/views/nhanvien/nhanvien.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
