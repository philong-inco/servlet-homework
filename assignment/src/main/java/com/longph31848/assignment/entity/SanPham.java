package com.longph31848.assignment.entity;

public class SanPham {
    private Long id;
    private String ma;
    private String ten;
    private Integer trangThai;

    public SanPhamBuilder getBuilder(){
        return new SanPhamBuilder();
    }

    public static class SanPhamBuilder {
        private SanPham sanPham;

        public SanPhamBuilder withId(Long id) {
            this.sanPham.id = id;
            return this;
        }

        public SanPhamBuilder withMa(String ma) {
            this.sanPham.ma = ma;
            return this;
        }

        public SanPhamBuilder withTen(String ten) {
            this.sanPham.ten = ten;
            return this;
        }

        public SanPhamBuilder withTrangThai(Integer trangThai) {
            this.sanPham.trangThai = trangThai;
            return this;
        }

        public SanPham build() {
            return this.sanPham;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "id=" + id +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                ", trangThai=" + trangThai +
                '}';
    }
}
