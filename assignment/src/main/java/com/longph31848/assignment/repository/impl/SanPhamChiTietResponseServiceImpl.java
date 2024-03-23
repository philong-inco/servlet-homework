package com.longph31848.assignment.repository.impl;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.repository.SanPhamChiTietResponseService;
import com.longph31848.assignment.response.SanPhamChiTietResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanPhamChiTietResponseServiceImpl implements SanPhamChiTietResponseService {

    private Connection cn;

    public SanPhamChiTietResponseServiceImpl() throws SQLException, ClassNotFoundException {
        this.cn = DataBaseConnection.getConnection();
    }

    @Override
    public List<SanPhamChiTietResponse> findByIdSanPham(Long id) throws SQLException {
        List<SanPhamChiTietResponse> list = new ArrayList<>();
        String query = "SELECT spct.id, spct.maspct, m.ten, kt.ten, spct.don_gia, spct.so_luong, spct.trang_thai, m.id, kt.id " +
                " FROM san_pham_chi_tiet spct " +
                " JOIN san_pham s ON spct.id_san_pham=s.id " +
                " JOIN mau_sac m ON spct.id_mau_sac=m.id " +
                " JOIN kich_thuoc kt ON spct.id_kich_thuoc=kt.id " +
                " WHERE spct.id_san_pham = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            SanPhamChiTietResponse spct = SanPhamChiTietResponse.getBuilder()
                    .id(rs.getLong(1))
                    .maSPCT(rs.getString(2))
                    .mauSac(rs.getString(3))
                    .kichThuoc(rs.getString(4))
                    .donGia(rs.getBigDecimal(5))
                    .soLuong(rs.getInt(6))
                    .trangThai(rs.getInt(7))
                    .idMauSac(rs.getLong(8))
                    .idKichThuoc(rs.getLong(9))
                    .build();

            list.add(spct);
        }

        return list;
    }

    @Override
    public SanPhamChiTietResponse findById(Long id) throws SQLException {
        String query = "SELECT spct.id, spct.maspct, m.ten, kt.ten, spct.don_gia, spct.so_luong, spct.trang_thai, m.id, kt.id " +
                " FROM san_pham_chi_tiet spct " +
                " JOIN san_pham s ON spct.id_san_pham=s.id " +
                " JOIN mau_sac m ON spct.id_mau_sac=m.id " +
                " JOIN kich_thuoc kt ON spct.id_kich_thuoc=kt.id " +
                " WHERE spct.id = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            SanPhamChiTietResponse spct = SanPhamChiTietResponse.getBuilder()
                    .id(rs.getLong(1))
                    .maSPCT(rs.getString(2))
                    .mauSac(rs.getString(3))
                    .kichThuoc(rs.getString(4))
                    .donGia(rs.getBigDecimal(5))
                    .soLuong(rs.getInt(6))
                    .trangThai(rs.getInt(7))
                    .idMauSac(rs.getLong(8))
                    .idKichThuoc(rs.getLong(9))
                    .build();

            return spct;
        }

        return null;
    }

    @Override
    public List<SanPhamChiTietResponse> finnByTrangThai(Integer trangThai) throws SQLException {
        List<SanPhamChiTietResponse> list = new ArrayList<>();
        String query = "SELECT spct.id, spct.maspct, m.ten, kt.ten, spct.don_gia, spct.so_luong, spct.trang_thai, m.id, kt.id, s.ten " +
                " FROM san_pham_chi_tiet spct " +
                " JOIN san_pham s ON spct.id_san_pham=s.id " +
                " JOIN mau_sac m ON spct.id_mau_sac=m.id " +
                " JOIN kich_thuoc kt ON spct.id_kich_thuoc=kt.id " +
                " WHERE spct.trang_thai = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setInt(1, trangThai);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            SanPhamChiTietResponse spct = SanPhamChiTietResponse.getBuilder()
                    .id(rs.getLong(1))
                    .maSPCT(rs.getString(2))
                    .mauSac(rs.getString(3))
                    .kichThuoc(rs.getString(4))
                    .donGia(rs.getBigDecimal(5))
                    .soLuong(rs.getInt(6))
                    .trangThai(rs.getInt(7))
                    .idMauSac(rs.getLong(8))
                    .idKichThuoc(rs.getLong(9))
                    .tenSanPham(rs.getString(10))
                    .build();

            list.add(spct);
        }

        return list;
    }

    @Override
    public SanPhamChiTietResponse isExist(Long idSP, Long idMS, Long idKT) throws SQLException {
        String query = "SELECT spct.id, spct.maspct, m.ten, kt.ten, spct.don_gia, spct.so_luong, spct.trang_thai, m.id, kt.id " +
                " FROM san_pham_chi_tiet spct " +
                " JOIN san_pham s ON spct.id_san_pham=s.id " +
                " JOIN mau_sac m ON spct.id_mau_sac=m.id " +
                " JOIN kich_thuoc kt ON spct.id_kich_thuoc=kt.id " +
                " WHERE s.id = ? AND m.id = ? AND kt.id = ? ";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setLong(1, idSP);
        ps.setLong(2, idMS);
        ps.setLong(3, idKT);
        System.out.println("IsExist query: " + ps.toString());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            SanPhamChiTietResponse spct = SanPhamChiTietResponse.getBuilder()
                    .id(rs.getLong(1))
                    .maSPCT(rs.getString(2))
                    .mauSac(rs.getString(3))
                    .kichThuoc(rs.getString(4))
                    .donGia(rs.getBigDecimal(5))
                    .soLuong(rs.getInt(6))
                    .trangThai(rs.getInt(7))
                    .idMauSac(rs.getLong(8))
                    .idKichThuoc(rs.getLong(9))
                    .build();

            return spct;
        }

        return null;
    }
}
