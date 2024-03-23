package com.longph31848.assignment.repository;

import com.longph31848.assignment.entity.KhachHang;

public interface KhachHangService extends Service<KhachHang> {
    boolean isExistMa(String ma);
}
