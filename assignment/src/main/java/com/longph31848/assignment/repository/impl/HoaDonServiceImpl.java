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
        String query = "SELECT trang_thai, id, id_khach_hang, id_nhan_vien, ngay_mua_hang FROM hoa_don WHERE id = ?";
        try(PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                HoaDon hoaDon = HoaDon.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withIdKhachHang(rs.getLong(3))
                        .withIdNhanVien(rs.getLong(4))
                        .withNgayMuaHang(rs.getLong(5))
                        .build();
                return hoaDon;
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public HoaDon insert(HoaDon hoaDon) throws SQLException {
        String queryInsert = "INSERT INTO hoa_don(id_khach_hang, id_nhan_vien, ngay_mua_hang, trang_thai) VALUES (?,?,?,?)";
        String queryResult = "SELECT * FROM servlet_assignment.hoa_don WHERE id = LAST_INSERT_ID()";
        try (PreparedStatement psInsert = cn.prepareStatement(queryInsert);
             PreparedStatement psResult = cn.prepareStatement(queryResult)) {

            psInsert.setLong(1, hoaDon.getIdKhachHang());
            psInsert.setLong(2, hoaDon.getIdNhanVien());
            psInsert.setLong(3, hoaDon.getNgayMuaHang());
            psInsert.setInt(4, hoaDon.getTrangThai());
            psInsert.executeUpdate();

            ResultSet rs = psResult.executeQuery();
            while (rs.next()) {
                HoaDon result = HoaDon.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withIdKhachHang(rs.getLong(3))
                        .withIdNhanVien(rs.getLong(4))
                        .withNgayMuaHang(rs.getLong(5))
                        .build();

                return result;
            }

        } catch (SQLException ex) {
            throw new SQLException();
        }
        return null;
    }

    @Override
    public HoaDon update(HoaDon hoaDon) {
        String query = "UPDATE hoa_don SET id_khach_hang = ?, id_nhan_vien = ?, trang_thai = ? WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)){
            ps.setLong(1, hoaDon.getIdKhachHang());
            ps.setLong(2, hoaDon.getIdNhanVien());
            ps.setLong(3, hoaDon.getTrangThai());
            ps.setLong(4, hoaDon.getId());
            System.out.println("Query update HD: " + ps.toString());
            ps.executeUpdate();
            return findById(hoaDon.getId());
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public HoaDon delete(Long id) {
        HoaDon result = findById(id);
        String queryDelete = "DELETE FROM hoa_don WHERE id = ?";
        try (PreparedStatement psDelete = cn.prepareStatement(queryDelete)) {
            psDelete.setLong(1, id);
            int rowUpdate = psDelete.executeUpdate();
            if (rowUpdate >= 1) {
                return result;
            }

        } catch (SQLException ex) {
            tatTrangThai(id);
        }
        return null;
    }

    @Override
    public void tatTrangThai(Long id) {
        String query = "UPDATE hoa_don SET trang_thai = 0 WHERE id = ?";
        try(PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
