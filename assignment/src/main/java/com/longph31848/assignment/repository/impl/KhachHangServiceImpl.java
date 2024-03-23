package com.longph31848.assignment.repository.impl;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.HoaDonChiTiet;
import com.longph31848.assignment.entity.KhachHang;
import com.longph31848.assignment.entity.KichThuoc;
import com.longph31848.assignment.repository.KhachHangService;
import com.longph31848.assignment.util.RenderQuery;

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
    public List<KhachHang> findByName(String name) throws SQLException {
        List<KhachHang> list = new ArrayList<>();
        String query = "SELECT * FROM khach_hang WHERE 1=1 AND "
                + RenderQuery.render("ten", name);

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
    public KhachHang findByMa(String ma) throws SQLException {
        String query = "SELECT * FROM khach_hang WHERE 1=1 AND "
                + RenderQuery.render("makh", ma);

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

                return khachHang;
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return null;
    }

    @Override
    public List<KhachHang> findByTrangThai(Integer trangThai) throws SQLException {
        List<KhachHang> list = new ArrayList<>();
        String query = "SELECT * FROM khach_hang WHERE trang_thai = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, trangThai);
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
    public KhachHang findById(Long id) throws SQLException {
        String query = "SELECT * FROM khach_hang WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang khachHang = KhachHang.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withMaKH(rs.getString(3))
                        .withSdt(rs.getString(4))
                        .withTen(rs.getString(5))
                        .build();

                return khachHang;
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return null;
    }

    @Override
    public KhachHang insert(KhachHang khachHang) throws SQLException {
        String queryInsert = "INSERT INTO khach_hang(makh, ten, trang_thai, sdt) VALUES (?,?,?,?)";
        String queryResult = "SELECT * FROM servlet_assignment.khach_hang WHERE id = LAST_INSERT_ID()";
        try (PreparedStatement psInsert = cn.prepareStatement(queryInsert);
             PreparedStatement psResult = cn.prepareStatement(queryResult)) {

            psInsert.setString(1, khachHang.getMaKH());
            psInsert.setString(2, khachHang.getTen());
            psInsert.setInt(3, khachHang.getTrangThai());
            psInsert.setString(4, khachHang.getSdt());
            psInsert.executeUpdate();

            ResultSet rs = psResult.executeQuery();
            while (rs.next()) {
                KhachHang result = KhachHang.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withMaKH(rs.getString(3))
                        .withSdt(rs.getString(4))
                        .withTen(rs.getString(5))
                        .build();

                return result;
            }

        } catch (SQLException ex) {
            throw new SQLException();
        }
        return null;
    }

    @Override
    public KhachHang update(KhachHang khachHang) throws SQLException {
        String queryUpdate = "UPDATE khach_hang SET trang_thai = ?, makh = ?, ten = ?, sdt = ? WHERE id = ?";
        KhachHang result;
        try (PreparedStatement psUpdate = cn.prepareStatement(queryUpdate)) {
            psUpdate.setInt(1, khachHang.getTrangThai());
            psUpdate.setString(2, khachHang.getMaKH());
            psUpdate.setString(3, khachHang.getTen());
            psUpdate.setString(4, khachHang.getSdt());
            psUpdate.setLong(5, khachHang.getId());
            psUpdate.executeUpdate();

            result = findById(khachHang.getId());

        } catch (SQLException ex) {
            throw new SQLException();
        }
        return result;
    }

    @Override
    public KhachHang delete(Long id) throws SQLException {
        KhachHang result = findById(id);
        String queryDelete = "DELETE FROM khach_hang WHERE id = ?";
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
        String query = "UPDATE khach_hang SET trang_thai = 0 WHERE id = ?";
        try(PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public boolean isExistMa(String ma) {
        String query = "SELECT makh FROM khach_hang WHERE makh = ?";
        try(PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
