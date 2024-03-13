package com.longph31848.assignment.repository.impl;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.KhachHang;
import com.longph31848.assignment.entity.MauSac;
import com.longph31848.assignment.repository.MauSacService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MauSacServiceImpl implements MauSacService {

    private Connection cn;

    public MauSacServiceImpl() throws SQLException, ClassNotFoundException {
        this.cn = DataBaseConnection.getConnection();
    }
    @Override
    public List<MauSac> getAll() throws SQLException {
        List<MauSac> list = new ArrayList<>();
        String query = "SELECT * FROM mau_sac";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSac mauSac = MauSac.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withMa(rs.getString(3))
                        .withTen(rs.getString(4))
                        .build();

                list.add(mauSac);
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return list;
    }

    @Override
    public List<MauSac> findByName(String name) {
        return null;
    }

    @Override
    public MauSac findByMa(String ma) {
        return null;
    }

    @Override
    public List<MauSac> findByTrangThai(Integer trangThai) {
        return null;
    }

    @Override
    public MauSac findById(Long id) {
        return null;
    }

    @Override
    public MauSac insert(MauSac mauSac) {
        return null;
    }

    @Override
    public MauSac update(MauSac mauSac) {
        return null;
    }

    @Override
    public MauSac delete(Long id) {
        return null;
    }
}
