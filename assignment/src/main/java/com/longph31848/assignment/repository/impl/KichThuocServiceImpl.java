package com.longph31848.assignment.repository.impl;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.KichThuoc;
import com.longph31848.assignment.repository.KichThuocService;
import com.longph31848.assignment.util.RenderQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KichThuocServiceImpl implements KichThuocService {

    private Connection cn;

    public KichThuocServiceImpl() throws SQLException, ClassNotFoundException {
        this.cn = DataBaseConnection.getConnection();
    }

    @Override
    public List<KichThuoc> getAll() throws SQLException {
        List<KichThuoc> list = new ArrayList<>();
        String query = "SELECT * FROM kich_thuoc";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KichThuoc kichThuoc = KichThuoc.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withMa(rs.getString(3))
                        .withTen(rs.getString(4))
                        .build();

                list.add(kichThuoc);
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return list;
    }

    @Override
    public List<KichThuoc> findByName(String name) throws SQLException {
        List<KichThuoc> list = new ArrayList<>();
        String query = "SELECT * FROM kich_thuoc WHERE 1=1 AND "
                + RenderQuery.render("ten", name);

        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KichThuoc kichThuoc = KichThuoc.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withMa(rs.getString(3))
                        .withTen(rs.getString(4))
                        .build();

                list.add(kichThuoc);
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return list;
    }

    @Override
    public KichThuoc findByMa(String ma) throws SQLException {
        String query = "SELECT * FROM kich_thuoc WHERE 1=1 AND "
                + RenderQuery.render("ma", ma);

        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KichThuoc kichThuoc = KichThuoc.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withMa(rs.getString(3))
                        .withTen(rs.getString(4))
                        .build();

                return kichThuoc;
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return null;
    }

    @Override
    public List<KichThuoc> findByTrangThai(Integer trangThai) throws SQLException {
        List<KichThuoc> list = new ArrayList<>();
        String query = "SELECT * FROM kich_thuoc WHERE trang_thai = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KichThuoc kichThuoc = KichThuoc.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withMa(rs.getString(3))
                        .withTen(rs.getString(4))
                        .build();

                list.add(kichThuoc);
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return list;
    }

    @Override
    public KichThuoc findById(Long id) throws SQLException {
        String query = "SELECT * FROM kich_thuoc WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KichThuoc kichThuoc = KichThuoc.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withMa(rs.getString(3))
                        .withTen(rs.getString(4))
                        .build();

                return kichThuoc;
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return null;
    }

    @Override
    public KichThuoc insert(KichThuoc kichThuoc) throws SQLException {
        String queryInsert = "INSERT INTO kich_thuoc(ma, ten, trang_thai) VALUES (?,?,?)";
        String queryResult = "SELECT * FROM servlet_assignment.kich_thuoc WHERE id = LAST_INSERT_ID()";
        try (PreparedStatement psInsert = cn.prepareStatement(queryInsert);
             PreparedStatement psResult = cn.prepareStatement(queryResult)) {

            psInsert.setString(1, kichThuoc.getMa());
            psInsert.setString(2, kichThuoc.getTen());
            psInsert.setInt(3, kichThuoc.getTrangThai());
            psInsert.executeUpdate();

            ResultSet rs = psResult.executeQuery();
            while (rs.next()) {
                KichThuoc result = KichThuoc.getBuilder()
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
    public KichThuoc update(KichThuoc kichThuoc) throws SQLException {
        String queryUpdate = "UPDATE kich_thuoc SET trang_thai = ?, ma = ?, ten = ? WHERE id = ?";
        KichThuoc result;
        try (PreparedStatement psUpdate = cn.prepareStatement(queryUpdate)) {
            psUpdate.setInt(1, kichThuoc.getTrangThai());
            psUpdate.setString(2, kichThuoc.getMa());
            psUpdate.setString(3, kichThuoc.getTen());
            psUpdate.setLong(4, kichThuoc.getId());
            psUpdate.executeUpdate();

            result = findById(kichThuoc.getId());

        } catch (SQLException ex) {
            throw new SQLException();
        }
        return result;
    }

    @Override
    public KichThuoc delete(Long id) throws SQLException {
        KichThuoc result = findById(id);
        String queryDelete = "DELETE FROM kich_thuoc WHERE id = ?";
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
