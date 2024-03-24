package com.longph31848.assignment.repository;

import com.longph31848.assignment.entity.NhanVien;

import java.sql.SQLException;

public interface NhanVienService extends Service<NhanVien> {
    boolean isExistMa(String ma);

    NhanVien findByUserNameAndMatKhau(String username, String password) throws SQLException;
}
