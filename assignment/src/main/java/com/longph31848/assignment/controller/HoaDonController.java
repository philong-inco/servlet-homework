package com.longph31848.assignment.controller;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.HoaDon;
import com.longph31848.assignment.entity.KhachHang;
import com.longph31848.assignment.entity.NhanVien;
import com.longph31848.assignment.entity.SanPham;
import com.longph31848.assignment.repository.*;
import com.longph31848.assignment.repository.impl.*;
import com.longph31848.assignment.response.HoaDonChiTietResponse;
import com.longph31848.assignment.response.HoaDonResponse;
import com.longph31848.assignment.response.SanPhamChiTietResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    private HoaDonService service;
    private HoaDonResponseService serviceResponse;
    private KhachHangService serviceKhachHang;

    private SanPhamChiTietResponseService serviceSanPhamChiTiet;
    private NhanVienService serviceNhanVien;
    private List<HoaDon> list;


    @Override
    public void init() {
        try {
            service = new HoaDonServiceImpl();
            serviceResponse = new HoaDonResponseServiceImpl();
            serviceKhachHang = new KhachHangServiceImpl();
            serviceSanPhamChiTiet = new SanPhamChiTietResponseServiceImpl();
            serviceNhanVien = new NhanVienServiceImpl();
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
            } else if (uri.contains("list")) {
                this.list(req, resp);
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

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<HoaDonResponse> list = serviceResponse.getAllResponse();
        Map<Long, List<HoaDonChiTietResponse>> map = new HashMap<>();
        for (HoaDonResponse hd : list) {
            List<HoaDonChiTietResponse> hdctList;
            hdctList = serviceResponse.getAllByIdHoaDon(hd.getId());
            map.put(hd.getId(), hdctList);
        }
        req.setAttribute("listhoadon", list);
        req.setAttribute("listhoadonchitiet", map);

        req.getRequestDispatcher("/views/hoadon/list.jsp").forward(req, resp);
    }

    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<KhachHang> listKhachHang = serviceKhachHang.findByTrangThai(1);
        List<SanPhamChiTietResponse> listSanPhamChiTiet = serviceSanPhamChiTiet.finnByTrangThai(1);
        List<NhanVien> listNhanVien = serviceNhanVien.findByTrangThai(1);
        req.setAttribute("listkhachhang", listKhachHang);
        req.setAttribute("listsanphamchitiet", listSanPhamChiTiet);
        req.setAttribute("listnhanvien", listNhanVien);
        req.getRequestDispatcher("/views/hoadon/create.jsp").forward(req, resp);
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long id = Long.parseLong(req.getParameter("id"));
        HoaDonResponse hd = serviceResponse.findHoaDonResponeById(id);
        List<KhachHang> listKhachHang = serviceKhachHang.findByTrangThai(1);
        List<HoaDonChiTietResponse> hdctList;
        hdctList = serviceResponse.getAllByIdHoaDon(hd.getId());
        List<NhanVien> listNhanVien = serviceNhanVien.findByTrangThai(1);
        req.setAttribute("hd", hd);
        req.setAttribute("listkhachhang", listKhachHang);
        req.setAttribute("listsanphamchitiet", hdctList);
        req.setAttribute("listnhanvien", listNhanVien);
        req.getRequestDispatcher("/views/hoadon/edit.jsp").forward(req, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        service.tatTrangThai(id);
        resp.sendRedirect("/assignment_war_exploded/hoa-don/list");
    }

    public void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        HoaDonResponse hd = serviceResponse.findHoaDonResponeById(id);
        List<HoaDonChiTietResponse> hdctList;
        hdctList = serviceResponse.getAllByIdHoaDon(hd.getId());
        req.setAttribute("hd", hd);
        req.setAttribute("hdct", hdctList);
        req.getRequestDispatcher("/views/hoadon/detail.jsp").forward(req, resp);
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long idHD = Long.parseLong(req.getParameter("id"));
        HoaDon hoaDonOld = service.findById(idHD);
        Long idKH = hoaDonOld.getIdKhachHang();
        Long idNV = hoaDonOld.getIdNhanVien();
        Integer trangThai = hoaDonOld.getTrangThai();
        if (req.getParameter("idKH") != null) idKH = Long.parseLong(req.getParameter("idKH"));
        if (req.getParameter("idNV") != null) idNV = Long.parseLong((req.getParameter("idNV")));
        if (req.getParameter("trangthai") != null) trangThai = Integer.parseInt((req.getParameter("trangthai")));
        HoaDon hoaDonUpdate = HoaDon.getBuilder()
                .withId(idHD)
                .withTrangThai(trangThai)
                .withIdKhachHang(idKH)
                .withIdNhanVien(idNV)
                .build();
        service.update(hoaDonUpdate);
        resp.sendRedirect("/assignment_war_exploded/hoa-don/list");
    }

    public void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
