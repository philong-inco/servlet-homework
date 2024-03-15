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

@WebServlet({
        "/hoa-don/list",
        "/hoa-don/create",
        "/hoa-don/edit",
        "/hoa-don/detail",
        "/hoa-don/store",
        "/hoa-don/delete",
        "/hoa-don/update",
})
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
        req.getRequestDispatcher("/views/hoadon/list.jsp").forward(req, resp);

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
