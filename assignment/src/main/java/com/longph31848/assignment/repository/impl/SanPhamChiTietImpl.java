package com.longph31848.assignment.repository.impl;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.NhanVien;
import com.longph31848.assignment.entity.SanPhamChiTiet;
import com.longph31848.assignment.repository.SanPhamChiTietService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanPhamChiTietImpl implements SanPhamChiTietService {

    private Connection cn;

    public SanPhamChiTietImpl() throws SQLException, ClassNotFoundException {
        this.cn = DataBaseConnection.getConnection();
    }
    @Override
    public List<SanPhamChiTiet> getAll() throws SQLException {
        List<SanPhamChiTiet> list = new ArrayList<>();
        String query = "SELECT * FROM san_pham_chi_tiet";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamChiTiet spct = SanPhamChiTiet.getBuilder()
                        .withDonGia(rs.getBigDecimal(1))
                        .withSoLuong(rs.getInt(2))
                        .withTrangThai(rs.getInt(3))
                        .withId(rs.getLong(4))
                        .withIdKichThuoc(rs.getLong(5))
                        .withIdMauSac(rs.getLong(6))
                        .withIdSanPham(rs.getLong(7))
                        .withMaSPCT(rs.getString(8))
                        .build();

                list.add(spct);
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return list;
    }

    @Override
    public List<SanPhamChiTiet> findByName(String name) {
        return null;
    }

    @Override
    public SanPhamChiTiet findByMa(String ma) {
        return null;
    }

    @Override
    public List<SanPhamChiTiet> findByTrangThai(Integer trangThai) {
        return null;
    }

    @Override
    public SanPhamChiTiet findById(Long id) {
        return null;
    }

    @Override
    public SanPhamChiTiet insert(SanPhamChiTiet sanPhamChiTiet) {
        return null;
    }

    @Override
    public SanPhamChiTiet update(SanPhamChiTiet sanPhamChiTiet) {
        return null;
    }

    @Override
    public SanPhamChiTiet delete(Long id) {
        return null;
    }
}
