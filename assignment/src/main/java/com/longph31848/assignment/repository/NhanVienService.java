package com.longph31848.assignment.repository;

import com.longph31848.assignment.entity.NhanVien;

public interface NhanVienService extends Service<NhanVien> {
    boolean isExistMa(String ma);
}
