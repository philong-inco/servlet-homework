package com.longph31848.assignment.controller;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.*;
import com.longph31848.assignment.repository.*;
import com.longph31848.assignment.repository.impl.*;
import com.longph31848.assignment.response.SanPhamChiTietResponse;
import com.longph31848.assignment.util.RenderMa;
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
import java.util.*;

@WebServlet({
        "/san-pham-chi-tiet/list",
        "/san-pham-chi-tiet/create",
        "/san-pham-chi-tiet/edit",
        "/san-pham-chi-tiet/detail",
        "/san-pham-chi-tiet/store",
        "/san-pham-chi-tiet/delete",
        "/san-pham-chi-tiet/update",
        "/san-pham-chi-tiet/properties"
})
public class SanPhamChiTietController extends HttpServlet {
    private Connection connection;
    private SanPhamChiTietService service;
    private SanPhamService serviceSanPham;
    private MauSacService serviceMauSac;
    private KichThuocService serviceKichThuoc;

    private SanPhamChiTietResponseService serviceBienThe;


    @Override
    public void init() {
        try {
            service = new SanPhamChiTietImpl();
            serviceMauSac = new MauSacServiceImpl();
            serviceSanPham = new SanPhamServiceImpl();
            serviceKichThuoc = new KichThuocServiceImpl();
            serviceBienThe = new SanPhamChiTietResponseServiceImpl();

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
            } else if (uri.contains("edit")) {
                this.edit(req, resp);
            } else if (uri.contains("store")) {
                this.store(req, resp);
            } else if (uri.contains("properties")) {
                this.properties(req, resp);
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
        Long idSP = Long.parseLong(req.getParameter("idSP"));
        SanPham sp = serviceSanPham.findById(idSP);
        List<SanPhamChiTietResponse> listBT = serviceBienThe.findByIdSanPham(idSP);
        req.setAttribute("sanphamchitietlist", listBT);
        req.setAttribute("sp", sp);
        req.getRequestDispatcher("/views/sanphamchitiet/list.jsp").forward(req, resp);
    }

    private void properties(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        Long idSanPham = Long.parseLong(req.getParameter("idSP"));
        SanPham sanPham = serviceSanPham.findById(idSanPham);
        List<MauSac> listMauSac = serviceMauSac.findByTrangThai(1);
        List<KichThuoc> listKichThuoc = serviceKichThuoc.findByTrangThai(1);

        System.out.println(sanPham);
        System.out.println(listMauSac);
        System.out.println(listKichThuoc);

        req.setAttribute("sp", sanPham);
        req.setAttribute("mausaclist", listMauSac);
        req.setAttribute("kichthuoclist", listKichThuoc);
        req.getRequestDispatcher("/views/sanphamchitiet/properties.jsp").forward(req, resp);
    }

    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Map<String, String[]> data = req.getParameterMap();
        Long idSP = Long.parseLong(req.getParameter("idSP"));
        SanPham sp = serviceSanPham.findById(idSP);
        String[] mauSacList = data.get("mausac");
        String[] kichThuocList = data.get("kichthuoc");

        List<SanPhamChiTietResponse> listRender = new ArrayList<>();
        List<SanPhamChiTietResponse> listExist = new ArrayList<>();
        for (String mauSac : mauSacList) {
            for (String kichThuoc : kichThuocList) {
                // check biến thể tồn tại
                SanPhamChiTietResponse spctCheck = serviceBienThe.isExist(idSP, Long.parseLong(mauSac), Long.parseLong(kichThuoc));
                if (spctCheck != null) {
                    listExist.add(spctCheck);
                    continue;
                }

                // Nếu chưa tồn tại thì cho vào list render
                String mauSacName = serviceMauSac.findById(Long.parseLong(mauSac)).getTen();
                String kichThuocName = serviceKichThuoc.findById(Long.parseLong(kichThuoc)).getTen();
                SanPhamChiTietResponse spct = SanPhamChiTietResponse.getBuilder()
                        .idMauSac(Long.parseLong(mauSac))
                        .mauSac(mauSacName)
                        .idKichThuoc(Long.parseLong(kichThuoc))
                        .kichThuoc(kichThuocName)
                        .soLuong(0)
                        .donGia(BigDecimal.valueOf(0))
                        .trangThai(1)
                        .build();
                listRender.add(spct);
            }
        }
        int sizeListExist = listExist.size();
        req.setAttribute("sizeExist", sizeListExist);
        req.setAttribute("listrender", listRender);
        req.setAttribute("listexist", listExist);
        req.setAttribute("sp", sp);
        req.getRequestDispatcher("/views/sanphamchitiet/create.jsp").forward(req, resp);
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long id = Long.parseLong(req.getParameter("id"));
        String mess = req.getParameter("mess");
        SanPhamChiTietResponse bienThe = serviceBienThe.findById(id);
        List<MauSac> mauSacList = serviceMauSac.getAll();
        List<KichThuoc> kichThuocList = serviceKichThuoc.getAll();
        SanPham sanPham = serviceSanPham.findById(Long.parseLong(req.getParameter("idSP")));
        req.setAttribute("bt", bienThe);
        req.setAttribute("mausaclist", mauSacList);
        req.setAttribute("kichthuoclist", kichThuocList);
        req.setAttribute("sp", sanPham);
        req.setAttribute("mess", mess);
        req.getRequestDispatcher("/views/sanphamchitiet/edit.jsp").forward(req, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long id = Long.parseLong(req.getParameter("id"));
        String idSP = req.getParameter("idSP");
        service.delete(id);
        resp.sendRedirect("/assignment_war_exploded/san-pham-chi-tiet/list?idSP=" + idSP);
    }

    public void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long id = Long.parseLong(req.getParameter("id"));
        Long idSP = Long.parseLong(req.getParameter("idSP"));
        Long idMauSac = Long.parseLong(req.getParameter("mausac"));
        Long idKichThuoc = Long.parseLong(req.getParameter("kichthuoc"));
        // check xem có sửa sang biến thể khác có sẵn không
        SanPhamChiTietResponse spctCheck = serviceBienThe.isExist(idSP, idMauSac, idKichThuoc);
        if (spctCheck != null && !spctCheck.getId().equals(id)) {
            System.out.println("Có sẵn: " + spctCheck.toString());
            resp.sendRedirect("/assignment_war_exploded/san-pham-chi-tiet/edit?id=" + id + "&idSP=" + idSP + "&mess=1");
            return;
        }
        BigDecimal donGia = new BigDecimal(req.getParameter("dongia"));
        Integer soLuong = Integer.parseInt(req.getParameter("soluong"));
        Integer trangThai = Integer.parseInt(req.getParameter("trangthai"));
        SanPhamChiTiet spct = SanPhamChiTiet.getBuilder()
                .withId(id)
                .withIdSanPham(idSP)
                .withIdMauSac(idMauSac)
                .withIdKichThuoc(idKichThuoc)
                .withDonGia(donGia)
                .withSoLuong(soLuong)
                .withTrangThai(trangThai)
                .build();

        service.update(spct);
        resp.sendRedirect("/assignment_war_exploded/san-pham-chi-tiet/list?idSP=" + idSP);
    }

    public void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Map<String, String[]> mapData = req.getParameterMap();
        System.out.println(mapData.size());
        if (mapData.size() <= 1) {
            resp.sendRedirect("/assignment_war_exploded/san-pham/list");
            return;
        }
        Set<String> keySet = mapData.keySet();
        Long idSp = Long.parseLong(mapData.get("idSP")[0]);

        int bienTheCount = (keySet.size() - 1) / 5;
        for (int i = 0; i < bienTheCount; i++) {
            SanPhamChiTiet spct = SanPhamChiTiet.getBuilder()
                    .withIdSanPham(idSp)
                    .withMaSPCT(RenderMa.renderMa("BT", 6))
                    .withIdMauSac(Long.parseLong(mapData.get("idMauSac_" + i)[0]))
                    .withIdKichThuoc(Long.parseLong(mapData.get("idKichThuoc_" + i)[0]))
                    .withDonGia(new BigDecimal(mapData.get("donGia_" + i)[0]))
                    .withSoLuong(Integer.parseInt(mapData.get("soLuong_" + i)[0]))
                    .withTrangThai(Integer.parseInt(mapData.get("trangThai_" + i)[0]))
                    .build();

            service.insert(spct);
            System.out.println(spct.toString()); //

            resp.sendRedirect("/assignment_war_exploded/san-pham/list");
        }
    }
}
