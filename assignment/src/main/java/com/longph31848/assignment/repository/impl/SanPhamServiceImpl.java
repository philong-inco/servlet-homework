package com.longph31848.assignment.repository.impl;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.SanPham;
import com.longph31848.assignment.entity.SanPhamChiTiet;
import com.longph31848.assignment.repository.SanPhamService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {

    private Connection cn;

    public SanPhamServiceImpl() throws SQLException, ClassNotFoundException {
        this.cn = DataBaseConnection.getConnection();
    }
    @Override
    public List<SanPham> getAll() throws SQLException {
        List<SanPham> list = new ArrayList<>();
        String query = "SELECT * FROM san_pham";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = SanPham.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withMa(rs.getString(3))
                        .withTen(rs.getString(4))
                        .build();

                list.add(sanPham);
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return list;
    }

    @Override
    public List<SanPham> findByName(String name) {
        return null;
    }

    @Override
    public SanPham findByMa(String ma) {
        return null;
    }

    @Override
    public List<SanPham> findByTrangThai(Integer trangThai) {
        return null;
    }

    @Override
    public SanPham findById(Long id) {
        return null;
    }

    @Override
    public SanPham insert(SanPham sanPham) {
        return null;
    }

    @Override
    public SanPham update(SanPham sanPham) {
        return null;
    }

    @Override
    public SanPham delete(Long id) {
        return null;
    }
}
