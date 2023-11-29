
package com.mycompany.first.DoAn;


import java.util.Scanner;


public abstract class SanPham {
    public String idSanPham;
    public String name;
    public float gia;
    public int soluong;
    public String ngaySx;
    public String donviSx;
    public String loai;
    
    Scanner sc = new Scanner(System.in);

    public SanPham() {
    }

    public SanPham(String idSanPham, String name, float gia, int soluong, String ngaySx, String donviSx, String loai) {
        this.idSanPham = idSanPham;
        this.name = name;
        this.gia = gia;
        this.soluong = soluong;
        this.ngaySx = ngaySx;
        this.donviSx = donviSx;
        this.loai = loai;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public String getName() {
        return name;
    }

    public float getGia() {
        return gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public String getNgaySx() {
        return ngaySx;
    }

    public String getDonviSx() {
        return donviSx;
    }

    public abstract String getLoai();

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setNgaySx(String ngaySx) {
        this.ngaySx = ngaySx;
    }

    public void setDonviSx(String donviSx) {
        this.donviSx = donviSx;
    }

    public abstract void setLoai(String loai);
    
    public abstract void nhapSanpham();
    
    public abstract void xuatSanpham();
}
