package com.longph31848.assignment.repository.impl;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.MauSac;
import com.longph31848.assignment.entity.NhanVien;
import com.longph31848.assignment.repository.NhanVienService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienServiceImpl implements NhanVienService {
    private Connection cn;

    public NhanVienServiceImpl() throws SQLException, ClassNotFoundException {
        this.cn = DataBaseConnection.getConnection();
    }

    @Override
    public List<NhanVien> getAll() throws SQLException {
        List<NhanVien> list = new ArrayList<>();
        String query = "SELECT * FROM nhan_vien";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = NhanVien.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withMaNV(rs.getString(3))
                        .withMatKhau(rs.getString(4))
                        .withTen(rs.getString(5))
                        .withTenDangNhap(rs.getString(6))
                        .build();

                list.add(nhanVien);
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return list;
    }

    @Override
    public List<NhanVien> findByName(String name) {
        return null;
    }

    @Override
    public NhanVien findByMa(String ma) {
        return null;
    }

    @Override
    public List<NhanVien> findByTrangThai(Integer trangThai) {
        return null;
    }

    @Override
    public NhanVien findById(Long id) {
        return null;
    }

    @Override
    public NhanVien insert(NhanVien nhanVien) {
        return null;
    }

    @Override
    public NhanVien update( NhanVien nhanVien) {
        return null;
    }

    @Override
    public NhanVien delete(Long id) {
        return null;
    }
}
