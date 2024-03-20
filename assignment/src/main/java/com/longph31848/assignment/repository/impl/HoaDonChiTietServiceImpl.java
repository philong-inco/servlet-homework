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

    @Override
    public void insert(HoaDonChiTiet hdct) {
        String query = "INSERT INTO hoa_don_chi_tiet(so_luong, don_gia, trang_thai, id_hoa_don, idspct) VALUES(?,?,?,?,?)";
        try(PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, hdct.getSoLuong());
            ps.setBigDecimal(2, hdct.getDonGia());
            ps.setInt(3, hdct.getTrangThai());
            ps.setLong(4, hdct.getIdHoaDon());
            ps.setLong(5, hdct.getIdSPCT());
            ps.execute();

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(HoaDonChiTiet hdct) {
        String query = "UPDATE hoa_don_chi_tiet SET so_luong = ?, don_gia = ?, trang_thai = ? WHERE id = ?";
        try(PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, hdct.getSoLuong());
            ps.setBigDecimal(2, hdct.getDonGia());
            ps.setInt(3, hdct.getTrangThai());
            ps.setLong(4, hdct.getId());
            ps.execute();

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM hoa_don_chi_tiet WHERE id = ?";
        try(PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setLong(1, id);
            ps.execute();

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void tatTrangThai(Long id) {
        String query = "UPDATE hoa_don_chi_tiet SET trang_thai = ? WHERE id = ?";
        try(PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, 0);
            ps.setLong(2, id);
            ps.execute();

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
