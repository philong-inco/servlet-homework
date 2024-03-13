package com.longph31848.assignment.repository.impl;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.HoaDonChiTiet;
import com.longph31848.assignment.entity.KhachHang;
import com.longph31848.assignment.repository.KhachHangService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHangServiceImpl implements KhachHangService {

    private Connection cn;

    public KhachHangServiceImpl() throws SQLException, ClassNotFoundException {
        this.cn = DataBaseConnection.getConnection();
    }

    @Override
    public List<KhachHang> getAll() throws SQLException {
        List<KhachHang> list = new ArrayList<>();
        String query = "SELECT * FROM khach_hang";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang khachHang = KhachHang.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withMaKH(rs.getString(3))
                        .withSdt(rs.getString(4))
                        .withTen(rs.getString(5))
                        .build();

                list.add(khachHang);
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return list;
    }

    @Override
    public List<KhachHang> findByName(String name) {
        return null;
    }

    @Override
    public KhachHang findByMa(String ma) {
        return null;
    }

    @Override
    public List<KhachHang> findByTrangThai(Integer trangThai) {
        return null;
    }

    @Override
    public KhachHang findById(Long id) {
        return null;
    }

    @Override
    public KhachHang insert(KhachHang khachHang) {
        return null;
    }

    @Override
    public KhachHang update(KhachHang khachHang) {
        return null;
    }

    @Override
    public KhachHang delete(Long id) {
        return null;
    }
}
