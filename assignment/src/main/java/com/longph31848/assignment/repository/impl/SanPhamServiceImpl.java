package com.longph31848.assignment.repository.impl;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.KichThuoc;
import com.longph31848.assignment.entity.SanPham;
import com.longph31848.assignment.entity.SanPhamChiTiet;
import com.longph31848.assignment.repository.SanPhamService;
import com.longph31848.assignment.util.RenderQuery;

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
    public List<SanPham> findByName(String name) throws SQLException {
        List<SanPham> list = new ArrayList<>();
        String query = "SELECT * FROM san_pham WHERE 1=1 AND "
                + RenderQuery.render("ten", name);

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
    public SanPham findByMa(String ma) throws SQLException {
        String query = "SELECT * FROM san_pham WHERE 1=1 AND "
                + RenderQuery.render("ma", ma);

        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = SanPham.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withMa(rs.getString(3))
                        .withTen(rs.getString(4))
                        .build();

                return sanPham;
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return null;
    }

    @Override
    public List<SanPham> findByTrangThai(Integer trangThai) throws SQLException {
        List<SanPham> list = new ArrayList<>();
        String query = "SELECT * FROM san_pham WHERE trang_thai = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, trangThai);
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
    public SanPham findById(Long id) throws SQLException {
        String query = "SELECT * FROM san_pham WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = SanPham.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withMa(rs.getString(3))
                        .withTen(rs.getString(4))
                        .build();

                return sanPham;
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return null;
    }

    @Override
    public SanPham insert(SanPham sanPham) throws SQLException {
        String queryInsert = "INSERT INTO san_pham(ma, ten, trang_thai) VALUES (?,?,?)";
        String queryResult = "SELECT * FROM servlet_assignment.san_pham WHERE id = LAST_INSERT_ID()";
        try (PreparedStatement psInsert = cn.prepareStatement(queryInsert);
             PreparedStatement psResult = cn.prepareStatement(queryResult)) {

            psInsert.setString(1, sanPham.getMa());
            psInsert.setString(2, sanPham.getTen());
            psInsert.setInt(3, sanPham.getTrangThai());
            psInsert.executeUpdate();

            ResultSet rs = psResult.executeQuery();
            while (rs.next()) {
                SanPham result = SanPham.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withMa(rs.getString(3))
                        .withTen(rs.getString(4))
                        .build();

                return result;
            }

        } catch (SQLException ex) {
            throw new SQLException();
        }
        return null;
    }

    @Override
    public SanPham update(SanPham sanPham) throws SQLException {
        String queryUpdate = "UPDATE san_pham SET trang_thai = ?, ma = ?, ten = ? WHERE id = ?";
        SanPham result;
        try (PreparedStatement psUpdate = cn.prepareStatement(queryUpdate)) {
            psUpdate.setInt(1, sanPham.getTrangThai());
            psUpdate.setString(2, sanPham.getMa());
            psUpdate.setString(3, sanPham.getTen());
            psUpdate.setLong(4, sanPham.getId());
            psUpdate.executeUpdate();

            result = findById(sanPham.getId());

        } catch (SQLException ex) {
            throw new SQLException();
        }
        return result;
    }

    @Override
    public SanPham delete(Long id) throws SQLException {
        SanPham result = findById(id);
        String queryDelete = "DELETE FROM san_pham WHERE id = ?";
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
