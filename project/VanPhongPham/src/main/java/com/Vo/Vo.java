
package com.Vo;

import com.SanPham.SanPham;
import java.util.Date;
import java.util.Scanner;

public class Vo implements SanPham {
    private String idSanpham;
    private String name;
    private float gia;
    private int soluong;
    private String ngaySx;
    private String donviSx;
    private String kichthuoc;
    
    Scanner sc = new Scanner(System.in);

    public Vo() {
    }

    public Vo(String idSanpham, String name, float gia, int soluong, String ngaySx, String donviSx, String kichthuoc) {
    this.idSanpham = idSanpham;
    this.name = name;
    this.gia = gia;
    this.soluong = soluong;
    this.ngaySx = ngaySx;
    this.donviSx = donviSx;
    this.kichthuoc = kichthuoc;
}

    
    public Vo(Vo a){
        this.idSanpham = a.idSanpham;
        this.name = a.name;
        this.gia = a.gia;
        this.soluong = a.soluong;
        this.ngaySx = a.ngaySx;
        this.donviSx = a.donviSx;
        this.kichthuoc = a.kichthuoc;
    }

    public String getIdSanpham() {
        return idSanpham;
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

    public String getKichthuoc() {
        return kichthuoc;
    }

    public void setIdSanpham(String idSanpham) {
        for(;;){
            System.out.print("Moi ban nhap id Vo: ");
            idSanpham = sc.nextLine();
            if(idSanpham.length() != 0) break; 
        }
        this.idSanpham = idSanpham;
    }

    public void setName(String name) {
        for(;;){
            System.out.print("Moi ban nhap ten Vo: ");
            name = sc.nextLine();
            if(name.length() != 0) break;
        }
        this.name = name;
    }

    public void setGia(float gia) {
        for(;;){
            System.out.print("Moi ban nhap gia cua Vo: ");
            gia = Float.parseFloat(sc.nextLine());
            if(gia > 0.0) break;
        }
        this.gia = gia;
    }

    public void setSoluong(int soluong) {
        for(;;){
            System.out.print("Moi ban nhap so luong cua Vo: ");
            soluong = Integer.parseInt(sc.nextLine());
            if(soluong >= 0) break;
        }
        this.soluong = soluong;
    }

    public void setNgaySx(String ngaySx) {
        Date date = new Date();
        ngaySx = date.toString();
        this.ngaySx = ngaySx;
    }

    public void setDonviSx(String donviSx) {
        for(;;){
            System.out.print("Moi ban nhap don vi san xuat Vo: ");
            donviSx = sc.nextLine();
            if(donviSx.length() != 0) break;
        }
        this.donviSx = donviSx;
    }

    public void setKichthuoc(String kichthuoc) {
        for(;;){
            System.out.print("Moi ban nhap kich thuoc Vo: ");
            kichthuoc = sc.nextLine();
            if(kichthuoc.length() != 0) break;
        }
        this.kichthuoc = kichthuoc;
    }
    
    @Override
    public void nhapSanpham(){
        setIdSanpham("");
        setName("");
        setGia(0);
        setSoluong(0);
        setNgaySx("");
        setDonviSx("");
        setKichthuoc("");
    }

    @Override
    public String toString() {
        return String.format("%-15s%-15s%-15f%-15d%-15s%-15s%-15s", idSanpham, name, gia, soluong, ngaySx, donviSx, kichthuoc);
    }
    
    @Override
    public void xuatSanpham(){
        System.out.print(toString());
    }

    @Override
    public void setIdSanpham() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }   
}