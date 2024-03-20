package com.longph31848.assignment.response;

import java.math.BigDecimal;

public class HoaDonResponse {
    private Long id;
    private Long idKhachHang;
    private String tenKhachHang;
    private String sdtKhachHang;
    private Long idNhanVien;
    private String tenNhanVien;
    private Integer tongSanPham;
    private BigDecimal tongTien;
    private Integer trangThai;

    private Long ngayMuaHang;

    public static HoaDonResponseBuilder getBuilder() {
        return new HoaDonResponseBuilder();
    }

    public static class HoaDonResponseBuilder {
        HoaDonResponse hoaDonResponse = new HoaDonResponse();

        public HoaDonResponseBuilder id(Long id) {
            this.hoaDonResponse.id = id;
            return this;
        }

        public HoaDonResponseBuilder idKhachHang(Long idKhachHang) {
            this.hoaDonResponse.idKhachHang = idKhachHang;
            return this;
        }

        public HoaDonResponseBuilder idNhanVien(Long idNhanVien) {
            this.hoaDonResponse.idNhanVien = idNhanVien;
            return this;
        }

        public HoaDonResponseBuilder tenKhachHang(String tenKhachHang) {
            this.hoaDonResponse.tenKhachHang = tenKhachHang;
            return this;
        }

        public HoaDonResponseBuilder sdtKhachHang(String sdtKhachHang) {
            this.hoaDonResponse.sdtKhachHang = sdtKhachHang;
            return this;
        }

        public HoaDonResponseBuilder tenNhanVien(String tenNhanVien) {
            this.hoaDonResponse.tenNhanVien = tenNhanVien;
            return this;
        }

        public HoaDonResponseBuilder tongSanPham(Integer tongSanPham) {
            this.hoaDonResponse.tongSanPham = tongSanPham;
            return this;
        }

        public HoaDonResponseBuilder tongTien(BigDecimal tongTien) {
            this.hoaDonResponse.tongTien = tongTien;
            return this;
        }

        public HoaDonResponseBuilder trangThai(Integer trangThai) {
            this.hoaDonResponse.trangThai = trangThai;
            return this;
        }

        public HoaDonResponseBuilder ngayMuaHang(Long ngayMuaHang) {
            this.hoaDonResponse.ngayMuaHang = ngayMuaHang;
            return this;
        }

        public HoaDonResponse build() {
            return this.hoaDonResponse;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Long idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSdtKhachHang() {
        return sdtKhachHang;
    }

    public void setSdtKhachHang(String sdtKhachHang) {
        this.sdtKhachHang = sdtKhachHang;
    }

    public Long getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Long idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public Integer getTongSanPham() {
        return tongSanPham;
    }

    public void setTongSanPham(Integer tongSanPham) {
        this.tongSanPham = tongSanPham;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public Long getNgayMuaHang() {
        return ngayMuaHang;
    }

    public void setNgayMuaHang(Long ngayMuaHang) {
        this.ngayMuaHang = ngayMuaHang;
    }

    @Override
    public String toString() {
        return "HoaDonResponse{" +
                "id=" + id +
                ", idKhachHang=" + idKhachHang +
                ", tenKhachHang='" + tenKhachHang + '\'' +
                ", sdtKhachHang='" + sdtKhachHang + '\'' +
                ", idNhanVien=" + idNhanVien +
                ", tenNhanVien='" + tenNhanVien + '\'' +
                ", tongSanPham=" + tongSanPham +
                ", tongTien=" + tongTien +
                ", trangThai=" + trangThai +
                ", ngayMuaHang=" + ngayMuaHang +
                '}';
    }
}
