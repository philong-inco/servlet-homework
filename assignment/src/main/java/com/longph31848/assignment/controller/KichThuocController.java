package com.longph31848.assignment.controller;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.KichThuoc;
import com.longph31848.assignment.repository.KichThuocService;
import com.longph31848.assignment.repository.impl.KichThuocServiceImpl;
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
        "/kich-thuoc/list",
        "/kich-thuoc/create",
        "/kich-thuoc/edit",
        "/kich-thuoc/detail",
        "/kich-thuoc/store",
        "/kich-thuoc/delete",
        "/kich-thuoc/update",
})
public class KichThuocController extends HttpServlet {

    private Connection connection;
    private KichThuocService service;
    private List<KichThuoc> list;

    @Override
    public void init() {
        try {
            connection = DataBaseConnection.getConnection();
            service = new KichThuocServiceImpl();
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
        req.setAttribute("kichthuoclist", list);
        req.getRequestDispatcher("/views/kichthuoc/list.jsp").forward(req, resp);
    }

    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/kichthuoc/create.jsp").forward(req, resp);
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long id = Long.parseLong(req.getParameter("id"));
        KichThuoc kichThuoc = service.findById(id);
        req.setAttribute("kt", kichThuoc);
        req.getRequestDispatcher("/views/kichthuoc/edit.jsp").forward(req, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long id = Long.parseLong(req.getParameter("id"));
        service.delete(id);
        resp.sendRedirect("/assignment_war_exploded/kich-thuoc/list");
    }

    public void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long id = Long.parseLong(req.getParameter("id"));
        KichThuoc kichThuoc = service.findById(id);
        req.setAttribute("kt", kichThuoc);
        req.getRequestDispatcher("/views/kichthuoc/detail.jsp").forward(req, resp);
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String idS = req.getParameter("id");
        Long id = Long.parseLong(idS);
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        Integer trangThai = Integer.parseInt(req.getParameter("trangthai"));
        KichThuoc kichThuoc = KichThuoc.getBuilder()
                .withId(id)
                .withMa(ma)
                .withTen(ten)
                .withTrangThai(trangThai)
                .build();
        service.update(kichThuoc);

        resp.sendRedirect("/assignment_war_exploded/kich-thuoc/list");
    }

    public void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        Integer trangThai = Integer.parseInt(req.getParameter("trangthai"));
        KichThuoc kichThuoc = KichThuoc.getBuilder()
                .withMa(ma)
                .withTen(ten)
                .withTrangThai(trangThai)
                .build();
        service.insert(kichThuoc);

        resp.sendRedirect("/assignment_war_exploded/kich-thuoc/list");
    }

}
