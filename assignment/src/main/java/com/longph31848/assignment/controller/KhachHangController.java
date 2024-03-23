package com.longph31848.assignment.controller;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.KhachHang;
import com.longph31848.assignment.entity.KichThuoc;
import com.longph31848.assignment.repository.KhachHangService;
import com.longph31848.assignment.repository.impl.KhachHangServiceImpl;
import com.longph31848.assignment.util.RenderMa;
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
        "/khach-hang/list",
        "/khach-hang/create",
        "/khach-hang/edit",
        "/khach-hang/detail",
        "/khach-hang/store",
        "/khach-hang/delete",
        "/khach-hang/update",
})
public class KhachHangController extends HttpServlet {


    private KhachHangService service;
    private List<KhachHang> list;

    @Override
    public void init() {
        try {

            service = new KhachHangServiceImpl();
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
        req.setAttribute("khachhanglist", list);
        req.getRequestDispatcher("/views/khachhang/list.jsp").forward(req, resp);
    }
    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/khachhang/create.jsp").forward(req, resp);
    }
    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long id = Long.parseLong(req.getParameter("id"));
        KhachHang khachHangq = service.findById(id);
        req.setAttribute("kh", khachHangq);
        req.getRequestDispatcher("/views/khachhang/edit.jsp").forward(req, resp);
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long id = Long.parseLong(req.getParameter("id"));
        service.delete(id);
        resp.sendRedirect("/assignment_war_exploded/khach-hang/list");
    }
    public void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long id = Long.parseLong(req.getParameter("id"));
        KhachHang khachHang = service.findById(id);
        req.setAttribute("kh", khachHang);
        req.getRequestDispatcher("/views/khachhang/detail.jsp").forward(req, resp);
    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String idS = req.getParameter("id");
        Long id = Long.parseLong(idS);
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        String sdt = req.getParameter("sdt");
        Integer trangThai = Integer.parseInt(req.getParameter("trangthai"));
        KhachHang khachHang = KhachHang.getBuilder()
                .withId(id)
                .withMaKH(ma)
                .withTen(ten)
                .withTrangThai(trangThai)
                .withSdt(sdt)
                .build();
        service.update(khachHang);

        resp.sendRedirect("/assignment_war_exploded/khach-hang/list");
    }
    public void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String ma = "";
        do {
            ma = RenderMa.renderMa("KH", 6);
        } while (service.isExistMa(ma));
        String ten = req.getParameter("ten");
        String sdt = req.getParameter("sdt");
        Integer trangThai = Integer.parseInt(req.getParameter("trangthai"));
        KhachHang khachHang = KhachHang.getBuilder()
                .withMaKH(ma)
                .withTen(ten)
                .withTrangThai(trangThai)
                .withSdt(sdt)
                .build();
        service.insert(khachHang);

        resp.sendRedirect("/assignment_war_exploded/khach-hang/list");
    }
}
