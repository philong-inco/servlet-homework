package com.longph31848.assignment.entity;

import java.math.BigDecimal;

public class HoaDonChiTiet {
    private Long id;
    private Long idHoaDon;
    private Long idSPCT;

    private Integer soLuong;
    private BigDecimal donGia;
    private Integer trangThai;

    public HoaDonChiTietBuilder getBuilder() {
        return new HoaDonChiTietBuilder();
    }

    public static class HoaDonChiTietBuilder {
        private HoaDonChiTiet hoaDonChiTiet;

        public HoaDonChiTietBuilder withId(Long id) {
            this.hoaDonChiTiet.id = id;
            return this;
        }

        public HoaDonChiTietBuilder withIdHoaDon(Long idHoaDon) {
            this.hoaDonChiTiet.idHoaDon = idHoaDon;
            return this;
        }

        public HoaDonChiTietBuilder withIdSPCT(Long idSPCT) {
            this.hoaDonChiTiet.idSPCT = idSPCT;
            return this;
        }

        public HoaDonChiTietBuilder withSoLuong(Integer soLuong) {
            this.hoaDonChiTiet.soLuong = soLuong;
            return this;
        }

        public HoaDonChiTietBuilder withDonGia(BigDecimal donGia) {
            this.hoaDonChiTiet.donGia = donGia;
            return this;
        }

        public HoaDonChiTietBuilder withTrangThai(Integer trangThai) {
            this.hoaDonChiTiet.trangThai = trangThai;
            return this;
        }

        public HoaDonChiTiet build() {
            return this.hoaDonChiTiet;
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
        return "HoaDonChiTiet{" +
                "id=" + id +
                ", idHoaDon=" + idHoaDon +
                ", idSPCT=" + idSPCT +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", trangThai=" + trangThai +
                '}';
    }
}
