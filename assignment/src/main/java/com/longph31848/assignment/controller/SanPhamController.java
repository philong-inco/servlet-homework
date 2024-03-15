package com.longph31848.assignment.controller;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.KichThuoc;
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
import java.sql.SQLException;
import java.util.List;

@WebServlet({
        "/san-pham/list",
        "/san-pham/create",
        "/san-pham/edit",
        "/san-pham/detail",
        "/san-pham/store",
        "/san-pham/delete",
        "/san-pham/update",
})
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
        try {
            String uri = req.getRequestURI();
            if (uri.contains("create")) {
                this.create(req, resp);
            } else if (uri.contains("edit")) {
                this.edit(req, resp);
            } else if (uri.contains("detail")) {
                this.detail(req, resp);
            } else if (uri.contains("edit")) {
                this.edit(req, resp);
            } else if (uri.contains("delete")) {
                this.delete(req, resp);
            } else {
                this.list(req, resp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String uri = req.getRequestURI();
            if (uri.contains("update")) {
                this.update(req, resp);
            } else if (uri.contains("store")) {
                this.store(req, resp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        list = service.getAll();
        req.setAttribute("sanphamlist", list);
        req.getRequestDispatcher("/views/sanpham/list.jsp").forward(req, resp);
    }

    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/sanpham/create.jsp").forward(req, resp);
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        System.out.println("vào edit");
        Long id = Long.parseLong(req.getParameter("id"));
        SanPham sanPham = service.findById(id);
        req.setAttribute("sp", sanPham);
        req.getRequestDispatcher("/views/sanpham/edit.jsp").forward(req, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        System.out.println("vào xóa" + req.getParameter("id"));
        Long id = Long.parseLong(req.getParameter("id"));
        service.delete(id);
        resp.sendRedirect("/assignment_war_exploded/san-pham/list");
    }

    public void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long id = Long.parseLong(req.getParameter("id"));
        SanPham sanPham = service.findById(id);
        req.setAttribute("sp", sanPham);
        req.getRequestDispatcher("/views/sanpham/detail.jsp").forward(req, resp);
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String idS = req.getParameter("id");
        Long id = Long.parseLong(idS);
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        Integer trangThai = Integer.parseInt(req.getParameter("trangthai"));
        SanPham sanPham = SanPham.getBuilder()
                .withId(id)
                .withMa(ma)
                .withTen(ten)
                .withTrangThai(trangThai)
                .build();
        service.update(sanPham);

        resp.sendRedirect("/assignment_war_exploded/san-pham/list");

    }

    public void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        Integer trangThai = Integer.parseInt(req.getParameter("trangthai"));
        SanPham sanPham = SanPham.getBuilder()
                .withMa(ma)
                .withTen(ten)
                .withTrangThai(trangThai)
                .build();
        service.insert(sanPham);

        resp.sendRedirect("/assignment_war_exploded/san-pham/list");
    }
}
