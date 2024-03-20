package com.longph31848.assignment.response;

import java.math.BigDecimal;

public class HoaDonChiTietResponse {
    private Long id;
    private Long idHoaDon;
    private Long idSPCT;
    private BigDecimal donGia;
    private Integer soLuong;
    private Integer trangThai;
    private String tenSanPham;
    private String tenMau;
    private String tenKichThuoc;

    public static HoaDonChiTietResponseBuilder getBuilder(){
        return new HoaDonChiTietResponseBuilder();
    }
    public static class HoaDonChiTietResponseBuilder{
        HoaDonChiTietResponse hdct = new HoaDonChiTietResponse();

        public HoaDonChiTietResponseBuilder id(Long id){
            this.hdct.id = id;
            return this;
        }
        public HoaDonChiTietResponseBuilder idHoaDon(Long id){
            this.hdct.idHoaDon = id;
            return this;
        }
        public HoaDonChiTietResponseBuilder idSPCT(Long id){
            this.hdct.idSPCT = id;
            return this;
        }
        public HoaDonChiTietResponseBuilder donGia(BigDecimal donGia){
            this.hdct.donGia = donGia;
            return this;
        }
        public HoaDonChiTietResponseBuilder soLuong(Integer soLuong){
            this.hdct.soLuong = soLuong;
            return this;
        }
        public HoaDonChiTietResponseBuilder trangThai(Integer trangThai){
            this.hdct.trangThai = trangThai;
            return this;
        }
        public HoaDonChiTietResponseBuilder tenSanPham(String tenSanPham){
            this.hdct.tenSanPham = tenSanPham;
            return this;
        }
        public HoaDonChiTietResponseBuilder tenMau(String tenMau){
            this.hdct.tenMau = tenMau;
            return this;
        }
        public HoaDonChiTietResponseBuilder tenKichThuoc(String tenKichThuoc){
            this.hdct.tenKichThuoc = tenKichThuoc;
            return this;
        }
        public HoaDonChiTietResponse build(){
            return this.hdct;
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(Long idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public Long getIdSPCT() {
        return idSPCT;
    }

    public void setIdSPCT(Long idSPCT) {
        this.idSPCT = idSPCT;
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

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    public String getTenKichThuoc() {
        return tenKichThuoc;
    }

    public void setTenKichThuoc(String tenKichThuoc) {
        this.tenKichThuoc = tenKichThuoc;
    }

    @Override
    public String toString() {
        return "HoaDonChiTietResponse{" +
                "id=" + id +
                ", idHoaDon=" + idHoaDon +
                ", idSPCT=" + idSPCT +
                ", donGia=" + donGia +
                ", soLuong=" + soLuong +
                ", trangThai=" + trangThai +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", tenMau='" + tenMau + '\'' +
                ", tenKichThuoc='" + tenKichThuoc + '\'' +
                '}';
    }
}
