package com.longph31848.assignment.entity;

public class KichThuoc {
    private Long id;
    private String ma;
    private String ten;
    private Integer trangThai;

    public static KichThuocBuilder getBuilder() {
        return new KichThuocBuilder();
    }

    public static class KichThuocBuilder {
        private KichThuoc kichThuoc = new KichThuoc();

        public KichThuocBuilder withId(Long id) {
            this.kichThuoc.id = id;
            return this;
        }

        public KichThuocBuilder withMa(String ma) {
            this.kichThuoc.ma = ma;
            return this;
        }

        public KichThuocBuilder withTen(String ten) {
            this.kichThuoc.ten = ten;
            return this;
        }

        public KichThuocBuilder withTrangThai(Integer trangThai) {
            this.kichThuoc.trangThai = trangThai;
            return this;
        }

        public KichThuoc build() {
            return this.kichThuoc;
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
        return "KichThuoc{" +
                "id=" + id +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                ", trangThai=" + trangThai +
                '}';
    }
}
