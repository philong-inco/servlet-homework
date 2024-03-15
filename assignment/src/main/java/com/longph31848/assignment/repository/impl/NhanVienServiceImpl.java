package com.longph31848.assignment.repository.impl;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.KichThuoc;
import com.longph31848.assignment.entity.MauSac;
import com.longph31848.assignment.entity.NhanVien;
import com.longph31848.assignment.repository.NhanVienService;
import com.longph31848.assignment.util.RenderQuery;

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
    public List<NhanVien> findByName(String name) throws SQLException {
        List<NhanVien> list = new ArrayList<>();
        String query = "SELECT * FROM nhan_vien WHERE 1=1 AND "
                + RenderQuery.render("ten", name);

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
    public NhanVien findByMa(String ma) throws SQLException {
        String query = "SELECT * FROM nhan_vien WHERE 1=1 AND "
                + RenderQuery.render("manv", ma);

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

                return nhanVien;
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return null;
    }

    @Override
    public List<NhanVien> findByTrangThai(Integer trangThai) throws SQLException {
        List<NhanVien> list = new ArrayList<>();
        String query = "SELECT * FROM nhan_vien WHERE trang_thai = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, trangThai);
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
    public NhanVien findById(Long id) throws SQLException {
        String query = "SELECT * FROM nhan_vien WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setLong(1, id);
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

                return nhanVien;
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return null;
    }

    @Override
    public NhanVien insert(NhanVien nhanVien) throws SQLException {
        String queryInsert = "INSERT INTO nhan_vien(manv, ten, trang_thai, mat_khau, ten_dang_nhap) VALUES (?,?,?,?,?)";
        String queryResult = "SELECT * FROM servlet_assignment.nhan_vien WHERE id = LAST_INSERT_ID()";
        try (PreparedStatement psInsert = cn.prepareStatement(queryInsert);
             PreparedStatement psResult = cn.prepareStatement(queryResult)) {

            psInsert.setString(1, nhanVien.getMaNV());
            psInsert.setString(2, nhanVien.getTen());
            psInsert.setInt(3, nhanVien.getTrangThai());
            psInsert.setString(4, nhanVien.getMatKhau());
            psInsert.setString(5, nhanVien.getTenDangNhap());

            psInsert.executeUpdate();

            ResultSet rs = psResult.executeQuery();
            while (rs.next()) {
                NhanVien result = NhanVien.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withMaNV(rs.getString(3))
                        .withMatKhau(rs.getString(4))
                        .withTen(rs.getString(5))
                        .withTenDangNhap(rs.getString(6))
                        .build();

                return result;
            }

        } catch (SQLException ex) {
            throw new SQLException();
        }
        return null;
    }

    @Override
    public NhanVien update( NhanVien nhanVien) throws SQLException {
        String queryUpdate = "UPDATE nhan_vien SET trang_thai = ?, manv = ?, ten = ?, mat_khau = ?, ten_dang_nhap = ? WHERE id = ?";
        NhanVien result;
        try (PreparedStatement psUpdate = cn.prepareStatement(queryUpdate)) {
            psUpdate.setInt(1, nhanVien.getTrangThai());
            psUpdate.setString(2, nhanVien.getMaNV());
            psUpdate.setString(3, nhanVien.getTen());
            psUpdate.setString(4, nhanVien.getMatKhau());
            psUpdate.setString(5, nhanVien.getTenDangNhap());
            psUpdate.setLong(6, nhanVien.getId());

            System.out.println(psUpdate.toString());

            psUpdate.executeUpdate();

            result = findById(nhanVien.getId());


        } catch (SQLException ex) {
            throw new SQLException();
        }
        return result;
    }

    @Override
    public NhanVien delete(Long id) throws SQLException {
        NhanVien result = findById(id);
        String queryDelete = "DELETE FROM nhan_vien WHERE id = ?";
        try (PreparedStatement psDelete = cn.prepareStatement(queryDelete)) {
            psDelete.setLong(1, id);
            int rowUpdate = psDelete.executeUpdate();
            if (rowUpdate >= 1) {
                return result;
            }

        } catch (SQLException ex) {
            throw new SQLException();
        }
        return null;
    }
}
