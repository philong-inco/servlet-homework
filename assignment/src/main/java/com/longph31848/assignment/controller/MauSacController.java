package com.longph31848.assignment.controller;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.KichThuoc;
import com.longph31848.assignment.entity.MauSac;
import com.longph31848.assignment.entity.NhanVien;
import com.longph31848.assignment.repository.MauSacService;
import com.longph31848.assignment.repository.impl.MauSacServiceImpl;
import com.longph31848.assignment.util.RenderMa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet({
        "/mau-sac/list",
        "/mau-sac/create",
        "/mau-sac/edit",
        "/mau-sac/detail",
        "/mau-sac/store",
        "/mau-sac/delete",
        "/mau-sac/update",
})
public class MauSacController extends HttpServlet {
    private MauSacService service;
    private List<MauSac> list;

    @Override
    public void init() {
        try {
            service = new MauSacServiceImpl();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getSession(false).getAttribute("account") == null){
                resp.sendRedirect("/assignment_war_exploded/login");
                return;
            }
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
            if (req.getSession(false).getAttribute("account") == null){
                resp.sendRedirect("/assignment_war_exploded/login");
                return;
            }
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
        req.setAttribute("mausaclist", list);
        req.getRequestDispatcher("/views/mausac/list.jsp").forward(req, resp);
    }
    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/mausac/create.jsp").forward(req, resp);
    }
    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        System.out.println("vào edit");
        Long id = Long.parseLong(req.getParameter("id"));
        MauSac mauSac = service.findById(id);
        req.setAttribute("ms", mauSac);
        req.getRequestDispatcher("/views/mausac/edit.jsp").forward(req, resp);
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        System.out.println("vào xóa" + req.getParameter("id"));
        Long id = Long.parseLong(req.getParameter("id"));
        service.delete(id);
        resp.sendRedirect("/assignment_war_exploded/mau-sac/list");
    }
    public void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long id = Long.parseLong(req.getParameter("id"));
        MauSac mauSac = service.findById(id);
        req.setAttribute("ms", mauSac);
        req.getRequestDispatcher("/views/mausac/detail.jsp").forward(req, resp);

    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String idS = req.getParameter("id");
        Long id = Long.parseLong(idS);
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        Integer trangThai = Integer.parseInt(req.getParameter("trangthai"));
        MauSac mauSac = MauSac.getBuilder()
                .withId(id)
                .withMa(ma)
                .withTen(ten)
                .withTrangThai(trangThai)
                .build();
        service.update(mauSac);

        resp.sendRedirect("/assignment_war_exploded/mau-sac/list");

    }
    public void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String ma = "";
        do {
            ma = RenderMa.renderMa("MS", 6);
        } while (service.isExistMa(ma));
        String ten = req.getParameter("ten");
        Integer trangThai = Integer.parseInt(req.getParameter("trangthai"));
        MauSac mauSac = MauSac.getBuilder()
                .withMa(ma)
                .withTen(ten)
                .withTrangThai(trangThai)
                .build();
        service.insert(mauSac);

        resp.sendRedirect("/assignment_war_exploded/mau-sac/list");

    }


}
