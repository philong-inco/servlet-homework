package com.longph31848.assignment.repository;

import com.longph31848.assignment.entity.SanPham;

import java.util.List;
import java.util.Optional;

public interface SanPhamService extends Service<SanPham> {

    boolean isExistMa(String ma);
}
