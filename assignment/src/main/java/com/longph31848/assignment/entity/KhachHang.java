package com.longph31848.assignment.entity;

public class KhachHang {
    private Long id;
    private String ten;
    private String sdt;
    private String maKH;
    private Integer trangThai;

    public static KhachHangBuilder getBuilder(){
        return new KhachHangBuilder();
    }

    public static class KhachHangBuilder {
        private KhachHang khachHang = new KhachHang();

        public KhachHangBuilder withId(Long id) {
            this.khachHang.id = id;
            return this;
        }

        public KhachHangBuilder withTen(String ten) {
            this.khachHang.ten = ten;
            return this;
        }

        public KhachHangBuilder withSdt(String sdt) {
            this.khachHang.sdt = sdt;
            return this;
        }

        public KhachHangBuilder withMaKH(String maKH) {
            this.khachHang.maKH = maKH;
            return this;
        }

        public KhachHangBuilder withTrangThai(Integer trangThai) {
            this.khachHang.trangThai = trangThai;
            return this;
        }

        public KhachHang build() {
            return this.khachHang;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", sdt='" + sdt + '\'' +
                ", maKH='" + maKH + '\'' +
                ", trangThai=" + trangThai +
                '}';
    }
}
