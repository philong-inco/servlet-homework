package com.longph31848.assignment.repository.impl;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.KhachHang;
import com.longph31848.assignment.entity.KichThuoc;
import com.longph31848.assignment.entity.MauSac;
import com.longph31848.assignment.repository.MauSacService;
import com.longph31848.assignment.util.RenderQuery;

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
    public List<MauSac> findByName(String name) throws SQLException {
        List<MauSac> list = new ArrayList<>();
        String query = "SELECT * FROM mau_sac WHERE 1=1 AND "
                + RenderQuery.render("ten", name);

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
    public MauSac findByMa(String ma) throws SQLException {
        String query = "SELECT * FROM mau_sac WHERE 1=1 AND "
                + RenderQuery.render("ma", ma);

        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSac mauSac = MauSac.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withMa(rs.getString(3))
                        .withTen(rs.getString(4))
                        .build();

                return mauSac;
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return null;
    }

    @Override
    public List<MauSac> findByTrangThai(Integer trangThai) throws SQLException {
        List<MauSac> list = new ArrayList<>();
        String query = "SELECT * FROM mau_sac WHERE trang_thai = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, trangThai);
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
    public MauSac findById(Long id) throws SQLException {
        String query = "SELECT * FROM mau_sac WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSac mauSac = MauSac.getBuilder()
                        .withTrangThai(rs.getInt(1))
                        .withId(rs.getLong(2))
                        .withMa(rs.getString(3))
                        .withTen(rs.getString(4))
                        .build();

                return mauSac;
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return null;
    }

    @Override
    public MauSac insert(MauSac mauSac) throws SQLException {
        String queryInsert = "INSERT INTO mau_sac(ma, ten, trang_thai) VALUES (?,?,?)";
        String queryResult = "SELECT * FROM servlet_assignment.mau_sac WHERE id = LAST_INSERT_ID()";
        try (PreparedStatement psInsert = cn.prepareStatement(queryInsert);
             PreparedStatement psResult = cn.prepareStatement(queryResult)) {

            psInsert.setString(1, mauSac.getMa());
            psInsert.setString(2, mauSac.getTen());
            psInsert.setInt(3, mauSac.getTrangThai());
            psInsert.executeUpdate();

            ResultSet rs = psResult.executeQuery();
            while (rs.next()) {
                MauSac result = MauSac.getBuilder()
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
    public MauSac update(MauSac mauSac) throws SQLException {
        String queryUpdate = "UPDATE mau_sac SET trang_thai = ?, ma = ?, ten = ? WHERE id = ?";
        MauSac result;
        try (PreparedStatement psUpdate = cn.prepareStatement(queryUpdate)) {
            psUpdate.setInt(1, mauSac.getTrangThai());
            psUpdate.setString(2, mauSac.getMa());
            psUpdate.setString(3, mauSac.getTen());
            psUpdate.setLong(4, mauSac.getId());
            psUpdate.executeUpdate();

            result = findById(mauSac.getId());

        } catch (SQLException ex) {
            throw new SQLException();
        }
        return result;
    }

    @Override
    public MauSac delete(Long id) throws SQLException {
        MauSac result = findById(id);
        String queryDelete = "DELETE FROM mau_sac WHERE id = ?";
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
        String query = "UPDATE mau_sac SET trang_thai = 0 WHERE id = ?";
        try(PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
