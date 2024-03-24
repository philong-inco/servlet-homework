package com.longph31848.assignment.controller;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.*;
import com.longph31848.assignment.repository.*;
import com.longph31848.assignment.repository.impl.*;
import com.longph31848.assignment.response.HoaDonChiTietResponse;
import com.longph31848.assignment.response.SanPhamChiTietResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
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

    private HoaDonChiTietService service;
    private HoaDonResponseService serviceHoaDon;

    private SanPhamChiTietService serviceSPCT;

    private SanPhamChiTietResponseService serviceSPCTResponse;

    @Override
    public void init() {
        try {
            service = new HoaDonChiTietServiceImpl();
            serviceHoaDon = new HoaDonResponseServiceImpl();
            serviceSPCTResponse = new SanPhamChiTietResponseServiceImpl();
            serviceSPCT = new SanPhamChiTietImpl();
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
            } else if (uri.contains("update")) {
                this.update(req, resp);
            } else if (uri.contains("list")) {
                this.list(req, resp);
            } else if (uri.contains("delete")) {
                this.delete(req, resp);
            } else if (uri.contains("store")) {
                this.store(req, resp);
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
        Long idHD = Long.parseLong(req.getParameter("idHD"));
        List<HoaDonChiTietResponse> listHDCT = serviceHoaDon.getAllByIdHoaDon(idHD);
        req.setAttribute("id", idHD);
        req.setAttribute("listHDCT", listHDCT);
        req.getRequestDispatcher("/views/hoadonchitiet/list.jsp").forward(req, resp);
    }

    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long idHD = Long.parseLong(req.getParameter("idHD"));
        List<HoaDonChiTietResponse> listHDCT = serviceHoaDon.getAllByIdHoaDon(idHD);
        List<SanPhamChiTietResponse> listSPCT = serviceSPCTResponse.finnByTrangThai(1);
        req.setAttribute("id", idHD);
        req.setAttribute("listSPCT", listSPCT);
        req.setAttribute("listHDCT", listHDCT);
        req.getRequestDispatcher("/views/hoadonchitiet/create.jsp").forward(req, resp);
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long idHDCT = Long.parseLong(req.getParameter("idHDCT"));
        HoaDonChiTietResponse hdct = serviceHoaDon.findByIdHDCT(idHDCT);
        List<SanPhamChiTietResponse> listSPCT = serviceSPCTResponse.finnByTrangThai(1);
        req.setAttribute("hdct", hdct);
        System.out.println(hdct);
        req.setAttribute("listSPCT", listSPCT);
        req.getRequestDispatcher("/views/hoadonchitiet/edit.jsp").forward(req, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idHDCT = Long.parseLong(req.getParameter("id"));
        String idHD = req.getParameter("idHD");
        service.delete(idHDCT);
        resp.sendRedirect("/assignment_war_exploded/hoa-don-chi-tiet/list?idHD=" + idHD);
    }

    public void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long idHDCT = Long.parseLong(req.getParameter("id"));
        HoaDonChiTietResponse hdctOld = serviceHoaDon.findByIdHDCT(idHDCT);
        Long idSPCT = hdctOld.getIdSPCT();
        Long idHD = Long.parseLong(req.getParameter("idHD"));
        BigDecimal donGia = new BigDecimal(req.getParameter("dongia"));
        Integer soLuong = Integer.parseInt(req.getParameter("soluong"));
        Integer trangThai = Integer.parseInt(req.getParameter("trangthai"));

        if (req.getParameter("idSPCT") != null) {
            idSPCT = Long.parseLong(req.getParameter("idSPCT"));
        }

        HoaDonChiTiet hdctUpdate = HoaDonChiTiet.getBuilder()
                .withId(idHDCT)
                .withIdHoaDon(idHD)
                .withDonGia(donGia)
                .withSoLuong(soLuong)
                .withTrangThai(trangThai)
                .withIdSPCT(idSPCT)
                .build();

        System.out.println("HD old: " + hdctOld.toString());
        System.out.println("HD update: " + hdctUpdate.toString());
        service.update(hdctUpdate);
        if (hdctOld.getIdSPCT() == hdctUpdate.getIdSPCT()) {
            // Case giữ nguyên sản phẩm và sửa số lượng
            if (hdctUpdate.getSoLuong() < hdctOld.getSoLuong()) {
                updateQuantityProduct(hdctUpdate.getIdSPCT(), -(hdctOld.getSoLuong() - hdctUpdate.getSoLuong()));
            } else if (hdctUpdate.getSoLuong() > hdctOld.getSoLuong()) {
                updateQuantityProduct(hdctUpdate.getIdSPCT(), (hdctUpdate.getSoLuong() - hdctOld.getSoLuong()));
            }
        } else {
            // Case sửa sang sản phẩm khác
            updateQuantityProduct(hdctOld.getIdSPCT(), -hdctOld.getSoLuong());
            updateQuantityProduct(hdctUpdate.getIdSPCT(), hdctUpdate.getSoLuong());
        }

        if (hdctOld.getTrangThai() != 0 && hdctUpdate.getTrangThai() == 0){
            // Case chuyển trạng thái sang trả hàng/ thêm lại sản phâm
        } else if (hdctOld.getTrangThai() == 0 && hdctUpdate.getTrangThai() != 0){
            // Case chuyển trạng thái trả hàng trở lại các trạng thái khác
        }
        resp.sendRedirect("/assignment_war_exploded/hoa-don-chi-tiet/list?idHD=" + idHD);
    }

    public void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idHD = Long.parseLong(req.getParameter("idHD"));
        BigDecimal donGia = new BigDecimal(req.getParameter("dongia"));
        Integer soLuong = Integer.parseInt(req.getParameter("soluong"));
        Integer trangThai = Integer.parseInt(req.getParameter("trangthai"));
        Long idSPCT = Long.parseLong(req.getParameter("idSPCT"));
        HoaDonChiTiet hdct = HoaDonChiTiet.getBuilder()
                .withDonGia(donGia)
                .withSoLuong(soLuong)
                .withIdHoaDon(idHD)
                .withTrangThai(trangThai)
                .withIdSPCT(idSPCT)
                .build();
        service.insert(hdct);
        resp.sendRedirect("/assignment_war_exploded/hoa-don-chi-tiet/create?idHD=" + idHD);
    }

    public void updateQuantityProduct(Long idSPCT, Integer totalSell) throws SQLException {
        SanPhamChiTiet spct = serviceSPCT.findById(idSPCT);
        Integer soLuong = spct.getSoLuong();
        spct.setSoLuong(soLuong - totalSell);
        serviceSPCT.update(spct);
    }
}
