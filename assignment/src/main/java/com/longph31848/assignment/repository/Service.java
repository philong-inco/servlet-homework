package com.longph31848.assignment.repository;

import com.longph31848.assignment.entity.SanPham;

import java.sql.SQLException;
import java.util.List;

public interface Service<T> {

    List<T> getAll() throws SQLException;

    List<T> findByName(String name) throws SQLException;

    T findByMa(String ma) throws SQLException;

    List<T> findByTrangThai(Integer trangThai) throws SQLException;

    T findById(Long id) throws SQLException;

    T insert(T t) throws SQLException;

    T update(T t) throws SQLException;

    T delete(Long id) throws SQLException;

    void tatTrangThai(Long id);
}
