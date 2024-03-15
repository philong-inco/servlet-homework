package com.longph31848.assignment.controller;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.NhanVien;
import com.longph31848.assignment.repository.NhanVienService;
import com.longph31848.assignment.repository.impl.NhanVienServiceImpl;
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
        "/nhan-vien/list",
        "/nhan-vien/create",
        "/nhan-vien/edit",
        "/nhan-vien/detail",
        "/nhan-vien/store",
        "/nhan-vien/delete",
        "/nhan-vien/update",
})
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
        req.setAttribute("nhanvienlist", list);
        req.getRequestDispatcher("/views/nhanvien/list.jsp").forward(req, resp);
    }
    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/nhanvien/create.jsp").forward(req, resp);
    }
    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        System.out.println("vào edit");
        Long id = Long.parseLong(req.getParameter("id"));
        NhanVien nhanVien = service.findById(id);
        req.setAttribute("nv", nhanVien);
        req.getRequestDispatcher("/views/nhanvien/edit.jsp").forward(req, resp);
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        System.out.println("vào xóa" + req.getParameter("id"));
        Long id = Long.parseLong(req.getParameter("id"));
        service.delete(id);
        resp.sendRedirect("/assignment_war_exploded/nhan-vien/list");
    }
    public void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long id = Long.parseLong(req.getParameter("id"));
        NhanVien nhanVien = service.findById(id);
        req.setAttribute("nv", nhanVien);
        req.getRequestDispatcher("/views/nhanvien/detail.jsp").forward(req, resp);
    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String idS = req.getParameter("id");
        Long id = Long.parseLong(idS);
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        String username = req.getParameter("username");
        String matkhau = req.getParameter("matkhau");
        Integer trangThai = Integer.parseInt(req.getParameter("trangthai"));
        NhanVien nhanVien = NhanVien.getBuilder()
                .withId(id)
                .withMaNV(ma)
                .withTen(ten)
                .withTenDangNhap(username)
                .withMatKhau(matkhau)
                .withTrangThai(trangThai)
                .build();
        service.update(nhanVien);

        resp.sendRedirect("/assignment_war_exploded/nhan-vien/list");

    }
    public void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        String username = req.getParameter("username");
        String matkhau = req.getParameter("matkhau");
        Integer trangThai = Integer.parseInt(req.getParameter("trangthai"));
        NhanVien nhanVien = NhanVien.getBuilder()
                .withMaNV(ma)
                .withTen(ten)
                .withTenDangNhap(username)
                .withMatKhau(matkhau)
                .withTrangThai(trangThai)
                .build();
        service.insert(nhanVien);

        resp.sendRedirect("/assignment_war_exploded/nhan-vien/list");

    }
}
