package com.longph31848.assignment.entity;

import java.time.LocalDate;

public class HoaDon {
    private Long id;
    private Long idNhanVien;
    private Long idKhachHang;
    private Long ngayMuaHang;
    private Integer trangThai;

    public static HoaDonBuilder getBuilder() {
        return new HoaDonBuilder();
    }

    public static class HoaDonBuilder {
        private HoaDon hoaDon = new HoaDon();

        public HoaDonBuilder withId(Long id) {
            this.hoaDon.id = id;
            return this;
        }

        public HoaDonBuilder withIdNhanVien(Long id) {
            this.hoaDon.idNhanVien = id;
            return this;
        }

        public HoaDonBuilder withIdKhachHang(Long id) {
            this.hoaDon.idKhachHang = id;
            return this;
        }

        public HoaDonBuilder withNgayMuaHang(Long data) {
            this.hoaDon.ngayMuaHang = data;
            return this;
        }

        public HoaDonBuilder withTrangThai(Integer trangThai) {
            this.hoaDon.trangThai = trangThai;
            return this;
        }

        public HoaDon build() {
            return this.hoaDon;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Long idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public Long getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Long idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Long getNgayMuaHang() {
        return ngayMuaHang;
    }

    public void setNgayMuaHang(Long ngayMuaHang) {
        this.ngayMuaHang = ngayMuaHang;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "id=" + id +
                ", idNhanVien=" + idNhanVien +
                ", idKhachHang=" + idKhachHang +
                ", ngayMuaHang=" + ngayMuaHang +
                ", trangThai=" + trangThai +
                '}';
    }
}
