package com.longph31848.assignment.repository;

import com.longph31848.assignment.response.HoaDonChiTietResponse;
import com.longph31848.assignment.response.HoaDonResponse;

import java.util.List;

public interface HoaDonResponseService {
    List<HoaDonResponse> getAllResponse();

    List<HoaDonChiTietResponse> getAllByIdHoaDon(Long id);

    HoaDonResponse findHoaDonResponeById(Long id);

    HoaDonChiTietResponse findByIdHDCT(Long id);

    List<HoaDonResponse> findByTrangThai(Integer trangThai);
}
