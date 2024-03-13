package com.longph31848.assignment.entity;

public class NhanVien {

    private Long id;
    private String ten;
    private String maNV;
    private String tenDangNhap;
    private String matKhau;
    private Integer trangThai;

    public static NhanVienBuilder getBuilder() {
        return new NhanVienBuilder();
    }

    public static class NhanVienBuilder {
        private NhanVien nhanVien = new NhanVien();

        public NhanVienBuilder withId(Long id) {
            this.nhanVien.id = id;
            return this;
        }

        public NhanVienBuilder withTen(String ten) {
            this.nhanVien.ten = ten;
            return this;
        }

        public NhanVienBuilder withMaNV(String maNV) {
            this.nhanVien.maNV = maNV;
            return this;
        }

        public NhanVienBuilder withTenDangNhap(String tenDangNhap) {
            this.nhanVien.tenDangNhap = tenDangNhap;
            return this;
        }

        public NhanVienBuilder withMatKhau(String matKhau) {
            this.nhanVien.matKhau = matKhau;
            return this;
        }

        public NhanVienBuilder withTrangThai(Integer trangThai) {
            this.nhanVien.trangThai = trangThai;
            return this;
        }

        public NhanVien build() {
            return this.nhanVien;
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

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", maNV='" + maNV + '\'' +
                ", tenDangNhap='" + tenDangNhap + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", trangThai=" + trangThai +
                '}';
    }
}
