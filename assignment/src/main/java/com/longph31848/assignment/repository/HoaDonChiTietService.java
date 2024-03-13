package com.longph31848.assignment.repository;

import com.longph31848.assignment.entity.HoaDonChiTiet;

import java.sql.SQLException;
import java.util.List;

public interface HoaDonChiTietService {

    List<HoaDonChiTiet> getAll() throws SQLException;

}
