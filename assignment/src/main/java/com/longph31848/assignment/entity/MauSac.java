package com.longph31848.assignment.entity;

public class MauSac {
    private Long id;
    private String ma;
    private String ten;
    private Integer trangThai;

    public MauSacBuilder getBuilder() {
        return new MauSacBuilder();
    }

    public static class MauSacBuilder {
       private MauSac mauSac;

        public MauSacBuilder withId(Long id) {
            this.mauSac.id = id;
            return this;
        }

        public MauSacBuilder withMa(String ma) {
            this.mauSac.ma = ma;
            return this;
        }

        public MauSacBuilder withTen(String ten) {
            this.mauSac.ten = ten;
            return this;
        }

        public MauSacBuilder withTrangThai(Integer trangThai) {
            this.mauSac.trangThai = trangThai;
            return this;
        }

        public MauSac build() {
            return this.mauSac;
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
        return "MauSac{" +
                "id=" + id +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                ", trangThai=" + trangThai +
                '}';
    }
}
