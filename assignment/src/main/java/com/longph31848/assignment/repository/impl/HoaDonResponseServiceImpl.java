package com.longph31848.assignment.repository.impl;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.repository.HoaDonResponseService;
import com.longph31848.assignment.repository.HoaDonService;
import com.longph31848.assignment.response.HoaDonChiTietResponse;
import com.longph31848.assignment.response.HoaDonResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoaDonResponseServiceImpl implements HoaDonResponseService {

    private Connection cn;

    public HoaDonResponseServiceImpl() throws SQLException, ClassNotFoundException {
        this.cn = DataBaseConnection.getConnection();
    }

    @Override
    public List<HoaDonResponse> getAllResponse() {
        List<HoaDonResponse> list = new ArrayList<>();
        String query = "SELECT hd.id, kh.id, kh.ten, kh.sdt, nv.id, nv.ten, \n" +
                "(SELECT SUM(so_luong) FROM hoa_don_chi_tiet WHERE id_hoa_don = hd.id AND trang_thai != 0) AS TongSanPham, \n" +
                "(SELECT SUM(don_gia * so_luong) FROM hoa_don_chi_tiet WHERE id_hoa_don = hd.id AND trang_thai != 0) AS TongTien,\n" +
                "hd.trang_thai, hd.ngay_mua_hang\n" +
                "FROM hoa_don hd\n" +
                "JOIN khach_hang kh ON hd.id_khach_hang=kh.id\n" +
                "JOIN nhan_vien nv ON hd.id_nhan_vien=nv.id\n" +
                "JOIN hoa_don_chi_tiet hdct ON hd.id=hdct.id_hoa_don\n" +
                "GROUP BY hd.id, kh.ten, kh.sdt, nv.ten, hd.trang_thai, nv.id, kh.id";

        try (PreparedStatement ps = cn.prepareStatement(query);
             ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                HoaDonResponse hd = HoaDonResponse.getBuilder()
                        .id(rs.getLong(1))
                        .idKhachHang(rs.getLong(2))
                        .tenKhachHang(rs.getString(3))
                        .sdtKhachHang(rs.getString(4))
                        .idNhanVien(rs.getLong(5))
                        .tenNhanVien(rs.getString(6))
                        .tongSanPham(rs.getInt(7))
                        .tongTien(rs.getBigDecimal(8))
                        .trangThai(rs.getInt(9))
                        .ngayMuaHang(rs.getLong(10))
                        .build();

                list.add(hd);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List<HoaDonChiTietResponse> getAllByIdHoaDon(Long id) {
        List<HoaDonChiTietResponse> list = new ArrayList<>();
        String query = "SELECT hdct.id, hdct.id_hoa_don, hdct.idspct, hdct.don_gia, hdct.so_luong, hdct.trang_thai, s.ten, ms.ten, kt.ten\n" +
                "FROM hoa_don_chi_tiet hdct\n" +
                "JOIN san_pham_chi_tiet spct ON hdct.idspct=spct.id\n" +
                "JOIN san_pham s ON spct.id_san_pham=s.id\n" +
                "JOIN mau_sac ms ON spct.id_mau_sac=ms.id\n" +
                "JOIN kich_thuoc kt ON spct.id_kich_thuoc=kt.id\n" +
                "WHERE hdct.id_hoa_don = ?";

        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTietResponse hdct = HoaDonChiTietResponse.getBuilder()
                        .id(rs.getLong(1))
                        .idHoaDon(rs.getLong(2))
                        .idSPCT(rs.getLong(3))
                        .donGia(rs.getBigDecimal(4))
                        .soLuong(rs.getInt(5))
                        .trangThai(rs.getInt(6))
                        .tenSanPham(rs.getString(7))
                        .tenMau(rs.getString(8))
                        .tenKichThuoc(rs.getString(9))
                        .build();

                list.add(hdct);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public HoaDonResponse findHoaDonResponeById(Long id) {
        String query = "SELECT hd.id, kh.id, kh.ten, kh.sdt, nv.id, nv.ten, \n" +
                "(SELECT SUM(so_luong) FROM hoa_don_chi_tiet WHERE id_hoa_don = hd.id AND trang_thai != 0) AS TongSanPham, \n" +
                "(SELECT SUM(don_gia * so_luong) FROM hoa_don_chi_tiet WHERE id_hoa_don = hd.id AND trang_thai != 0) AS TongTien,\n" +
                "hd.trang_thai , hd.ngay_mua_hang\n" +
                "FROM hoa_don hd\n" +
                "JOIN khach_hang kh ON hd.id_khach_hang=kh.id\n" +
                "JOIN nhan_vien nv ON hd.id_nhan_vien=nv.id\n" +
                "JOIN hoa_don_chi_tiet hdct ON hd.id=hdct.id_hoa_don\n" +
                "WHERE hd.id = ?\n" +
                "GROUP BY hd.id, kh.ten, kh.sdt, nv.ten, hd.trang_thai, nv.id, kh.id\n";


        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setLong(1, id);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonResponse hd = HoaDonResponse.getBuilder()
                        .id(rs.getLong(1))
                        .idKhachHang(rs.getLong(2))
                        .tenKhachHang(rs.getString(3))
                        .sdtKhachHang(rs.getString(4))
                        .idNhanVien(rs.getLong(5))
                        .tenNhanVien(rs.getString(6))
                        .tongSanPham(rs.getInt(7))
                        .tongTien(rs.getBigDecimal(8))
                        .trangThai(rs.getInt(9))
                        .ngayMuaHang(rs.getLong(10))
                        .build();

                return hd;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public HoaDonChiTietResponse findByIdHDCT(Long id) {

        String query = "SELECT hdct.id, hdct.id_hoa_don, hdct.idspct, hdct.don_gia, hdct.so_luong, hdct.trang_thai, s.ten, ms.ten, kt.ten\n" +
                "FROM hoa_don_chi_tiet hdct\n" +
                "JOIN san_pham_chi_tiet spct ON hdct.idspct=spct.id\n" +
                "JOIN san_pham s ON spct.id_san_pham=s.id\n" +
                "JOIN mau_sac ms ON spct.id_mau_sac=ms.id\n" +
                "JOIN kich_thuoc kt ON spct.id_kich_thuoc=kt.id\n" +
                "WHERE hdct.id = ?";

        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setLong(1, id);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTietResponse hdct = HoaDonChiTietResponse.getBuilder()
                        .id(rs.getLong(1))
                        .idHoaDon(rs.getLong(2))
                        .idSPCT(rs.getLong(3))
                        .donGia(rs.getBigDecimal(4))
                        .soLuong(rs.getInt(5))
                        .trangThai(rs.getInt(6))
                        .tenSanPham(rs.getString(7))
                        .tenMau(rs.getString(8))
                        .tenKichThuoc(rs.getString(9))
                        .build();

                return hdct;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HoaDonResponse> findByTrangThai(Integer trangThai) {
        List<HoaDonResponse> list = new ArrayList<>();
        String query = "SELECT hd.id, kh.id, kh.ten, kh.sdt, nv.id, nv.ten, \n" +
                "(SELECT SUM(so_luong) FROM hoa_don_chi_tiet WHERE id_hoa_don = hd.id AND trang_thai != 0) AS TongSanPham, \n" +
                "(SELECT SUM(don_gia * so_luong) FROM hoa_don_chi_tiet WHERE id_hoa_don = hd.id AND trang_thai != 0) AS TongTien,\n" +
                "hd.trang_thai, hd.ngay_mua_hang\n" +
                "FROM hoa_don hd\n" +
                "JOIN khach_hang kh ON hd.id_khach_hang=kh.id\n" +
                "JOIN nhan_vien nv ON hd.id_nhan_vien=nv.id\n" +
                "JOIN hoa_don_chi_tiet hdct ON hd.id=hdct.id_hoa_don\n" +
                "GROUP BY hd.id, kh.ten, kh.sdt, nv.ten, hd.trang_thai, nv.id, kh.id\n" +
                "HAVING hd.trang_thai = ?";

        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, trangThai);
            System.out.println("Query HD by TT: "+ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonResponse hd = HoaDonResponse.getBuilder()
                        .id(rs.getLong(1))
                        .idKhachHang(rs.getLong(2))
                        .tenKhachHang(rs.getString(3))
                        .sdtKhachHang(rs.getString(4))
                        .idNhanVien(rs.getLong(5))
                        .tenNhanVien(rs.getString(6))
                        .tongSanPham(rs.getInt(7))
                        .tongTien(rs.getBigDecimal(8))
                        .trangThai(rs.getInt(9))
                        .ngayMuaHang(rs.getLong(10))
                        .build();

                list.add(hd);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
