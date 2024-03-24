package com.longph31848.assignment.controller;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.*;
import com.longph31848.assignment.repository.*;
import com.longph31848.assignment.repository.impl.*;
import com.longph31848.assignment.response.HoaDonChiTietResponse;
import com.longph31848.assignment.response.HoaDonResponse;
import com.longph31848.assignment.response.SanPhamChiTietResponse;
import com.longph31848.assignment.util.DateNow;
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
    private HoaDonChiTietService serviceHoaDonChiTiet;
    private SanPhamChiTietResponseService serviceSanPhamChiTiet;
    private NhanVienService serviceNhanVien;

    private SanPhamChiTietService serviceSPCT;
    private List<HoaDon> list;


    @Override
    public void init() {
        try {
            service = new HoaDonServiceImpl();
            serviceResponse = new HoaDonResponseServiceImpl();
            serviceKhachHang = new KhachHangServiceImpl();
            serviceSanPhamChiTiet = new SanPhamChiTietResponseServiceImpl();
            serviceNhanVien = new NhanVienServiceImpl();
            serviceHoaDonChiTiet = new HoaDonChiTietServiceImpl();
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

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<HoaDonResponse> list;
        String tt = req.getParameter("tt");
        System.out.println("TT: " + tt);
        if (tt != null) {
            list = serviceResponse.findByTrangThai(Integer.parseInt(tt)); // chưa get đc list
        } else {
            list = serviceResponse.getAllResponse();
        }
        System.out.println(list.size());

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

        System.out.println("SizeKH: " + listKhachHang.size());
        System.out.println("SizeNV: " + listNhanVien.size());
        System.out.println("SizeSPCT: " + listSanPhamChiTiet.size());

        req.setAttribute("listkhachhang", listKhachHang);
        req.setAttribute("listsanphamchitiet", listSanPhamChiTiet);
        req.setAttribute("listnhanvien", listNhanVien);
        req.getRequestDispatcher("/views/hoadon/create.jsp").forward(req, resp);
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long id = Long.parseLong(req.getParameter("id"));
        HoaDonResponse hd = serviceResponse.findHoaDonResponeById(id);
        List<KhachHang> listKhachHang = serviceKhachHang.findByTrangThai(1);
        List<NhanVien> listNhanVien = serviceNhanVien.findByTrangThai(1);
        List<HoaDonChiTietResponse> hdctList;
        hdctList = serviceResponse.getAllByIdHoaDon(hd.getId());

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
        System.out.println("HD Old: " + hoaDonOld.toString());
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
        System.out.println(hoaDonUpdate.toString());
        service.update(hoaDonUpdate);
        resp.sendRedirect("/assignment_war_exploded/hoa-don/list");
    }

    public void store(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        // Get parameter
        Map<String, String[]> map = req.getParameterMap();
        Set<String> setKey = map.keySet();
        List<String> soLuongList = new ArrayList<>();
        for (String key : setKey) {
            if (key.contains("soluong_")) {
                soLuongList.add(key);
                System.out.println("soLuong: " + key);
            }
        }
        // Tạo 1 hóa đơn
        Long idNV = Long.parseLong(req.getParameter("idNV"));
        Long idKH = Long.parseLong(req.getParameter("idKH"));
        Long ngayMuaHang = DateNow.getTimeNow();
        Integer trangThai = Integer.parseInt(req.getParameter("trangthai"));
        HoaDon hd = HoaDon.getBuilder()
                .withIdNhanVien(idNV)
                .withIdKhachHang(idKH)
                .withNgayMuaHang(ngayMuaHang)
                .withTrangThai(trangThai)
                .build();
        HoaDon hoaDonNew = service.insert(hd);
        boolean hoaDonIsEmpty = true;
        // Thêm sản phẩm vào
        for (int i = 0; i < soLuongList.size(); i++) {
            String indexLoop = soLuongList.get(i);
            indexLoop = indexLoop.substring(indexLoop.indexOf("_") + 1,  indexLoop.length());
            System.out.println("Indexloop: "+indexLoop);
            Integer check = Integer.parseInt(map.get("soluong_" + indexLoop)[0]);

            // Nếu số lượng khác 0 thì thêm sản phẩm đó vào hóa đơn
            if (check != 0){
                Long idSPCT = Long.parseLong(map.get("idSPCT_" + indexLoop)[0]);
                Integer soLuong = check;
                BigDecimal donGia = new BigDecimal(map.get("dongia_" + indexLoop)[0]);
                Integer trangThaiHDCT = 3;
                if (hoaDonNew.getTrangThai() == 1){
                    trangThaiHDCT = 1;
                }
                HoaDonChiTiet hdct = HoaDonChiTiet.getBuilder()
                        .withIdSPCT(idSPCT)
                        .withIdHoaDon(hoaDonNew.getId())
                        .withTrangThai(trangThaiHDCT)
                        .withSoLuong(soLuong)
                        .withDonGia(donGia)
                        .build();
                serviceHoaDonChiTiet.insert(hdct);
                updateQuantityProduct(hdct.getIdSPCT(), hdct.getSoLuong());
                hoaDonIsEmpty = false;
            }
        }
        // Nếu không có sản phẩm nào thì xóa hóa đơn rỗng vừa tạo đi
        if (hoaDonIsEmpty){
            service.delete(hoaDonNew.getId());
        }
        resp.sendRedirect("/assignment_war_exploded/hoa-don/list");

    }

    public void updateQuantityProduct(Long idSPCT, Integer totalSell) throws SQLException {
        SanPhamChiTiet spct = serviceSPCT.findById(idSPCT);
        Integer soLuong = spct.getSoLuong();
        spct.setSoLuong(soLuong - totalSell);
        serviceSPCT.update(spct);
    }
}
