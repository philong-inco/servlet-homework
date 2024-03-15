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

@WebServlet({
        "/hoa-don-chi-tiet/list",
        "/hoa-don-chi-tiet/create",
        "/hoa-don-chi-tiet/edit",
        "/hoa-don-chi-tiet/detail",
        "/hoa-don-chi-tiet/store",
        "/hoa-don-chi-tiet/delete",
        "/hoa-don-chi-tiet/update"
})
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
        req.getRequestDispatcher("/views/hoadonchitiet/list.jsp").forward(req, resp);
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
