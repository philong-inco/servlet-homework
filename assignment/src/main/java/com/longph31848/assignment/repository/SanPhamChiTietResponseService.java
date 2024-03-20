package com.longph31848.assignment.repository;

import com.longph31848.assignment.entity.SanPhamChiTiet;
import com.longph31848.assignment.response.SanPhamChiTietResponse;

import java.sql.SQLException;
import java.util.List;

public interface SanPhamChiTietResponseService {

    List<SanPhamChiTietResponse> findByIdSanPham(Long id) throws SQLException;

    SanPhamChiTietResponse findById(Long id) throws SQLException;

    List<SanPhamChiTietResponse> finnByTrangThai(Integer trangThai) throws SQLException;


}
