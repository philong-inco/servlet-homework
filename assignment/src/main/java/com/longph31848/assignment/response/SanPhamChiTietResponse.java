package com.longph31848.assignment.response;

import java.math.BigDecimal;

public class SanPhamChiTietResponse {

    private Long id;
    private String maSPCT;
    private Long idMauSac;
    private String mauSac;
    private Long idKichThuoc;
    private String kichThuoc;
    private BigDecimal donGia;
    private Integer soLuong;
    private Integer trangThai;

    private String tenSanPham;

    public static SanPhamChiTietResponseBuilder getBuilder() {
        return new SanPhamChiTietResponseBuilder();
    }

    public static class SanPhamChiTietResponseBuilder {
        SanPhamChiTietResponse bienThe = new SanPhamChiTietResponse();

        public SanPhamChiTietResponseBuilder id(Long id) {
            this.bienThe.id = id;
            return this;
        }

        public SanPhamChiTietResponseBuilder maSPCT(String ma) {
            this.bienThe.maSPCT = ma;
            return this;
        }

        public SanPhamChiTietResponseBuilder mauSac(String mau) {
            this.bienThe.mauSac = mau;
            return this;
        }

        public SanPhamChiTietResponseBuilder kichThuoc(String kichThuoc) {
            this.bienThe.kichThuoc = kichThuoc;
            return this;
        }

        public SanPhamChiTietResponseBuilder donGia(BigDecimal gia) {
            this.bienThe.donGia = gia;
            return this;
        }

        public SanPhamChiTietResponseBuilder soLuong(Integer soLuong) {
            this.bienThe.soLuong = soLuong;
            return this;
        }

        public SanPhamChiTietResponseBuilder trangThai(Integer trangThai) {
            this.bienThe.trangThai = trangThai;
            return this;
        }

        public SanPhamChiTietResponseBuilder idKichThuoc(Long idKichThuoc) {
            this.bienThe.idKichThuoc = idKichThuoc;
            return this;
        }

        public SanPhamChiTietResponseBuilder idMauSac(Long idMauSac) {
            this.bienThe.idMauSac = idMauSac;
            return this;
        }

        public SanPhamChiTietResponseBuilder tenSanPham(String tenSP) {
            this.bienThe.tenSanPham = tenSP;
            return this;
        }

        public SanPhamChiTietResponse build() {
            return this.bienThe;
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

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public Long getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(Long idMauSac) {
        this.idMauSac = idMauSac;
    }

    public Long getIdKichThuoc() {
        return idKichThuoc;
    }

    public void setIdKichThuoc(Long idKichThuoc) {
        this.idKichThuoc = idKichThuoc;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    @Override
    public String toString() {
        return "SanPhamChiTietResponse{" +
                "id=" + id +
                ", maSPCT='" + maSPCT + '\'' +
                ", idMauSac=" + idMauSac +
                ", mauSac='" + mauSac + '\'' +
                ", idKichThuoc=" + idKichThuoc +
                ", kichThuoc='" + kichThuoc + '\'' +
                ", donGia=" + donGia +
                ", soLuong=" + soLuong +
                ", trangThai=" + trangThai +
                ", tenSanPham='" + tenSanPham + '\'' +
                '}';
    }
}
