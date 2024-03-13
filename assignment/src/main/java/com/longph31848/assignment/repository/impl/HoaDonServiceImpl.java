package com.longph31848.assignment.repository.impl;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.HoaDon;
import com.longph31848.assignment.entity.KichThuoc;
import com.longph31848.assignment.repository.HoaDonService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoaDonServiceImpl implements HoaDonService {

    private Connection cn;

    public HoaDonServiceImpl() throws SQLException, ClassNotFoundException {
        this.cn = DataBaseConnection.getConnection();
    }

    @Override
    public List<HoaDon> getAll() throws SQLException {
        List<HoaDon> list = new ArrayList<>();
        String query = "SELECT * FROM hoa_don";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = HoaDon.getBuilder()
                        .withNgayMuaHang(rs.getLong(1))
                        .withTrangThai(rs.getInt(2))
                        .withId(rs.getLong(3))
                        .withIdKhachHang(rs.getLong(4))
                        .withIdNhanVien(rs.getLong(5))
                        .build();

                list.add(hoaDon);
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return list;
    }

    @Override
    public List<HoaDon> findByName(String name) {
        return null;
    }

    @Override
    public HoaDon findByMa(String ma) {
        return null;
    }

    @Override
    public List<HoaDon> findByTrangThai(Integer trangThai) {
        return null;
    }

    @Override
    public HoaDon findById(Long id) {
        return null;
    }

    @Override
    public HoaDon insert(HoaDon hoaDon) {
        return null;
    }

    @Override
    public HoaDon update(HoaDon hoaDon) {
        return null;
    }

    @Override
    public HoaDon delete(Long id) {
        return null;
    }
}
