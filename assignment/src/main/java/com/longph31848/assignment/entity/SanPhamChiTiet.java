package com.longph31848.assignment.entity;

import java.math.BigDecimal;

public class SanPhamChiTiet {
    private Long id;
    private String maSPCT;
    private Long idKichThuoc;
    private Long idMauSac;
    private Long idSanPham;
    private Integer soLuong;
    private BigDecimal donGia;
    private Integer trangThai;

    public static SanPhamChiTietBuilder getBuilder() {
        return new SanPhamChiTietBuilder();
    }

    public static class SanPhamChiTietBuilder {
        private SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet();

        public SanPhamChiTietBuilder withId(Long id) {
            this.sanPhamChiTiet.id = id;
            return this;
        }

        public SanPhamChiTietBuilder withMaSPCT(String maSPCT) {
            this.sanPhamChiTiet.maSPCT = maSPCT;
            return this;
        }

        public SanPhamChiTietBuilder withIdKichThuoc(Long idKichThuoc) {
            this.sanPhamChiTiet.idKichThuoc = idKichThuoc;
            return this;
        }

        public SanPhamChiTietBuilder withIdMauSac(Long idMauSac) {
            this.sanPhamChiTiet.idMauSac = idMauSac;
            return this;
        }

        public SanPhamChiTietBuilder withIdSanPham(Long idSanPham) {
            this.sanPhamChiTiet.idSanPham = idSanPham;
            return this;
        }

        public SanPhamChiTietBuilder withSoLuong(Integer soLuong) {
            this.sanPhamChiTiet.soLuong = soLuong;
            return this;
        }

        public SanPhamChiTietBuilder withDonGia(BigDecimal donGia) {
            this.sanPhamChiTiet.donGia = donGia;
            return this;
        }

        public SanPhamChiTietBuilder withTrangThai(Integer trangThai) {
            this.sanPhamChiTiet.trangThai = trangThai;
            return this;
        }

        public SanPhamChiTiet build() {
            return this.sanPhamChiTiet;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public Long getIdKichThuoc() {
        return idKichThuoc;
    }

    public void setIdKichThuoc(Long idKichThuoc) {
        this.idKichThuoc = idKichThuoc;
    }

    public Long getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(Long idMauSac) {
        this.idMauSac = idMauSac;
    }

    public Long getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Long idSanPham) {
        this.idSanPham = idSanPham;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SanPhamChiTiet{" +
                "id=" + id +
                ", maSPCT='" + maSPCT + '\'' +
                ", idKichThuoc=" + idKichThuoc +
                ", idMauSac=" + idMauSac +
                ", idSanPham=" + idSanPham +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", trangThai=" + trangThai +
                '}';
    }
}
