package com.longph31848.assignment.repository;

import com.longph31848.assignment.entity.HoaDon;
import com.longph31848.assignment.entity.HoaDonChiTiet;

import java.sql.SQLException;
import java.util.List;

public interface HoaDonChiTietService {

    List<HoaDonChiTiet> getAll() throws SQLException;

    void insert(HoaDonChiTiet hdct);

    void update(HoaDonChiTiet hdct);

    void delete(Long id);

    void tatTrangThai(Long id);

}
