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

@WebServlet({
        "/san-pham-chi-tiet/list",
        "/san-pham-chi-tiet/create",
        "/san-pham-chi-tiet/edit",
        "/san-pham-chi-tiet/detail",
        "/san-pham-chi-tiet/store",
        "/san-pham-chi-tiet/delete",
        "/san-pham-chi-tiet/update",
})
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

        String uri = req.getRequestURI();
        if (uri.contains("create")) {
            this.create(req, resp);
        } else if (uri.contains("edit")) {
            this.edit(req, resp);
        } else if (uri.contains("detail")) {
            this.detail(req, resp);
        } else if (uri.contains("update")) {
            this.update(req, resp);
        } else if (uri.contains("edit")) {
            this.edit(req, resp);
        } else if (uri.contains("store")) {
            this.store(req, resp);
        } else {
            this.list(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("update")) {
            this.update(req, resp);
        } else if (uri.contains("store")) {
            this.store(req, resp);
        }
    }
    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sanphamchitietlist", list);
        req.getRequestDispatcher("/views/sanphamchitiet/list.jsp").forward(req, resp);
    }
    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    public void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    public void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
