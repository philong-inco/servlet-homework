package com.longph31848.assignment.repository.impl;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.HoaDon;
import com.longph31848.assignment.entity.HoaDonChiTiet;
import com.longph31848.assignment.repository.HoaDonChiTietService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {
    private Connection cn;

    public HoaDonChiTietServiceImpl() throws SQLException, ClassNotFoundException {
        this.cn = DataBaseConnection.getConnection();
    }


    @Override
    public List<HoaDonChiTiet> getAll() throws SQLException {
        List<HoaDonChiTiet> list = new ArrayList<>();
        String query = "SELECT * FROM hoa_don_chi_tiet";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hoaDonChiTiet = HoaDonChiTiet.getBuilder()
                        .withDonGia(rs.getBigDecimal(1))
                        .withSoLuong(rs.getInt(2))
                        .withTrangThai(rs.getInt(3))
                        .withId(rs.getLong(4))
                        .withIdHoaDon(rs.getLong(5))
                        .withIdSPCT(rs.getLong(6))
                        .build();

                list.add(hoaDonChiTiet);
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return list;
    }
}
