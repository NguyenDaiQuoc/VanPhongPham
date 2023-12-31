package com.PhuongThucThanhToan;

public class PhuongThucThanhToan {
    private String maPhuongThuc;
    private String ten;
    private String mota;

    // Default constructor
    public PhuongThucThanhToan() {
        this.maPhuongThuc = "";
        this.ten = "";
        this.mota = "";
    }

    // Parameterized constructor
    public PhuongThucThanhToan(String maPhuongThuc, String ten, String mota) {
        this.maPhuongThuc = maPhuongThuc;
        this.ten = ten;
        this.mota = mota;
    }

    // Copy constructor
    public PhuongThucThanhToan(PhuongThucThanhToan other) {
        this.maPhuongThuc = other.maPhuongThuc;
        this.ten = other.ten;
        this.mota = other.mota;
    }

    // Getters
    public String getMaPhuongThuc() {
        return maPhuongThuc;
    }

    public String getTen() {
        return ten;
    }

    public String getMota() {
        return mota;
    }

    // Setters
    public void setMaPhuongThuc(String maPhuongThuc) {
        this.maPhuongThuc = maPhuongThuc;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
