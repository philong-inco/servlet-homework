package com.longph31848.assignment.repository.impl;

import com.longph31848.assignment.db.DataBaseConnection;
import com.longph31848.assignment.entity.KichThuoc;
import com.longph31848.assignment.entity.NhanVien;
import com.longph31848.assignment.entity.SanPham;
import com.longph31848.assignment.entity.SanPhamChiTiet;
import com.longph31848.assignment.repository.SanPhamChiTietService;
import com.longph31848.assignment.response.SanPhamChiTietResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanPhamChiTietImpl implements SanPhamChiTietService {

    private Connection cn;

    public SanPhamChiTietImpl() throws SQLException, ClassNotFoundException {
        this.cn = DataBaseConnection.getConnection();
    }
    @Override
    public List<SanPhamChiTiet> getAll() throws SQLException {
        List<SanPhamChiTiet> list = new ArrayList<>();
        String query = "SELECT * FROM san_pham_chi_tiet";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamChiTiet spct = SanPhamChiTiet.getBuilder()
                        .withDonGia(rs.getBigDecimal(1))
                        .withSoLuong(rs.getInt(2))
                        .withTrangThai(rs.getInt(3))
                        .withId(rs.getLong(4))
                        .withIdKichThuoc(rs.getLong(5))
                        .withIdMauSac(rs.getLong(6))
                        .withIdSanPham(rs.getLong(7))
                        .withMaSPCT(rs.getString(8))
                        .build();

                list.add(spct);
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return list;
    }

    @Override
    public List<SanPhamChiTiet> findByName(String name) {
        return null;
    }

    @Override
    public SanPhamChiTiet findByMa(String ma) {
        return null;
    }

    @Override
    public List<SanPhamChiTiet> findByTrangThai(Integer trangThai) {
        return null;
    }

    @Override
    public SanPhamChiTiet findById(Long id) throws SQLException {
        String query = "SELECT * FROM san_pham_chi_tiet WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamChiTiet spct = SanPhamChiTiet.getBuilder()
                        .withDonGia(rs.getBigDecimal(1))
                        .withSoLuong(rs.getInt(2))
                        .withTrangThai(rs.getInt(3))
                        .withId(rs.getLong(4))
                        .withIdKichThuoc(rs.getLong(5))
                        .withIdMauSac(rs.getLong(6))
                        .withIdSanPham(rs.getLong(7))
                        .withMaSPCT(rs.getString(8))
                        .build();

                return spct;
            }
        } catch (SQLException ex) {
            throw new SQLException();
        }

        return null;
    }

    @Override
    public SanPhamChiTiet insert(SanPhamChiTiet sanPhamChiTiet) throws SQLException {
        String queryInsert = "INSERT INTO san_pham_chi_tiet(don_gia, so_luong, trang_thai, id_kich_thuoc, id_mau_sac, id_san_pham, maspct) VALUES (?,?,?,?,?,?,?)";
        String queryResult = "SELECT * FROM servlet_assignment.san_pham_chi_tiet WHERE id = LAST_INSERT_ID()";
        try (PreparedStatement psInsert = cn.prepareStatement(queryInsert);
             PreparedStatement psResult = cn.prepareStatement(queryResult)) {

            psInsert.setBigDecimal(1, sanPhamChiTiet.getDonGia());
            psInsert.setInt(2, sanPhamChiTiet.getSoLuong());
            psInsert.setInt(3, sanPhamChiTiet.getTrangThai());
            psInsert.setLong(4, sanPhamChiTiet.getIdKichThuoc());
            psInsert.setLong(5, sanPhamChiTiet.getIdMauSac());
            psInsert.setLong(6, sanPhamChiTiet.getIdSanPham());
            psInsert.setString(7, sanPhamChiTiet.getMaSPCT());

            System.out.println("-------");
            System.out.println(psInsert.toString());
            psInsert.executeUpdate();

            ResultSet rs = psResult.executeQuery();
            while (rs.next()) {
                SanPhamChiTiet result = SanPhamChiTiet.getBuilder()
                        .withDonGia(rs.getBigDecimal(1))
                        .withSoLuong(rs.getInt(2))
                        .withTrangThai(rs.getInt(3))
                        .withId(rs.getLong(4))
                        .withIdKichThuoc(rs.getLong(5))
                        .withIdMauSac(rs.getLong(6))
                        .withIdSanPham(rs.getLong(7))
                        .withMaSPCT(rs.getString(8))
                        .build();

                return result;
            }

        } catch (SQLException ex) {
            throw new SQLException();
        }
        return null;
    }

    @Override
    public SanPhamChiTiet update(SanPhamChiTiet sanPhamChiTiet) {
        String query = "UPDATE san_pham_chi_tiet SET don_gia = ?, so_luong = ?, trang_thai = ?, id_kich_thuoc = ?, id_mau_sac = ? WHERE id = ?";
        try(PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setBigDecimal(1, sanPhamChiTiet.getDonGia());
            ps.setInt(2, sanPhamChiTiet.getSoLuong());
            ps.setInt(3, sanPhamChiTiet.getTrangThai());
            ps.setLong(4, sanPhamChiTiet.getIdKichThuoc());
            ps.setLong(5, sanPhamChiTiet.getIdMauSac());
            ps.setLong(6, sanPhamChiTiet.getId());
            ps.executeUpdate();

            return findById(sanPhamChiTiet.getId());
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public SanPhamChiTiet delete(Long id) throws SQLException {
        SanPhamChiTiet result = findById(id);
        String queryDelete = "DELETE FROM san_pham_chi_tiet WHERE id = ?";
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
    public void tatTrangThai(Long id){
        String query = "UPDATE san_pham_chi_tiet SET trang_thai = 0 WHERE id = ?";
        try(PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
