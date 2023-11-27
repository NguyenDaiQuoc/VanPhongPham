
package com.mycompany.first.DoAn;


import java.util.Date;
import java.util.Scanner;


public class SanPham {
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

    public String getLoai() {
        return loai;
    }

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

    public void setLoai(String loai) {
        this.loai = loai;
    }
    
    public void nhapSanpham(){
        System.out.print("Moi ban nhap id san pham: ");
        idSanPham = sc.nextLine();
        System.out.print("Moi ban nhap ten san pham: ");
        name = sc.nextLine();
        System.out.print("Moi ban nhap gia san pham: ");
        gia = Float.parseFloat(sc.nextLine());
        System.out.print("Moi ban nhap so luong san pham: ");
        soluong = Integer.parseInt(sc.nextLine());
        Date date = new Date();
        ngaySx = date.toString();
        System.out.print("Moi ban nhap don vi san xuat san pham: ");
        donviSx = sc.nextLine();
        System.out.print("Moi ban nhap loai san pham: ");
        loai = sc.nextLine();
    }

    @Override
    public String toString() {
        return String.format("%-15s%-15s%-15f%-15d%-15s%-15s%-15s", idSanPham, name, gia, soluong, ngaySx, donviSx, loai);
    }
    
    
    public void xuatSanPham(){
        System.out.println(toString());
    }
    
    
    
    
}
