/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.first.DoAn;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Sach implements SanPham {
    private String idSanpham;
    private String name;
    private String tacgia;
    private float gia;
    private int soluong;
    private String ngaySx;
    private String donviSx;
    private String loai;
    
    Scanner sc = new Scanner(System.in);

    public Sach() {
    }

    public Sach(String idSanpham, String name, String tacgia, float gia, int soluong, String ngaySx, String donviSx, String loai) {
        this.idSanpham = idSanpham;
        this.name = name;
        this.tacgia = tacgia;
        this.gia = gia;
        this.soluong = soluong;
        this.ngaySx = ngaySx;
        this.donviSx = donviSx;
        this.loai = loai;
    }
    
    public Sach(Sach a){
        this.idSanpham = a.idSanpham;
        this.name = a.name;
        this.tacgia = a.tacgia;
        this.gia = a.gia;
        this.soluong = a.soluong;
        this.ngaySx = a.ngaySx;
        this.donviSx = a.donviSx;
        this.loai = a.loai;
    }

    @Override
    public String getIdSanpham() {
        return idSanpham;
    }

    public String getName() {
        return name;
    }

    public String getTacgia() {
        return tacgia;
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

    public void setIdSanpham(String idSanpham) {
        for(;;){
            System.out.print("Moi ban nhap id Sach: ");
            idSanpham = sc.nextLine();
            if(idSanpham.length() != 0) break; 
        }        
        this.idSanpham = idSanpham;
    }

    public void setName(String name) {
        for(;;){
            System.out.print("Moi ban nhap ten Sach: ");
            name = sc.nextLine();
            if(name.length() != 0) break;
        }
        this.name = name;
    }

    public void setTacgia(String tacgia) {
        for(;;){
            System.out.print("Moi ban nhap tac gia cua Sach: ");
            tacgia = sc.nextLine();
            if(tacgia.length() != 0) break;
        }
        this.tacgia = tacgia;
    }

    public void setGia(float gia) {
        for(;;){
            System.out.print("Moi ban nhap gia Sach: ");
            gia = Float.parseFloat(sc.nextLine());
            if(gia > 0.0) break;
        }
        this.gia = gia;
    }

    public void setSoluong(int soluong) {
        for(;;){
            System.out.print("Moi ban nhap so luong cua Sach: ");
            soluong = Integer.parseInt(sc.nextLine());
            if(soluong > 0) break;
        }
        this.soluong = soluong;
    }
    
    public String toString1(Date date){
        return String.format("%tB %<te, %<tY", date);
    }

    public void setNgaySx(String ngaySx) {
        Date date = new Date();
        ngaySx = toString1(date);
        this.ngaySx = ngaySx;
    }

    public void setDonviSx(String donviSx) {
        for(;;){
            System.out.print("Moi ban nhap don vi san xuat Sach: ");
            donviSx = sc.nextLine();
            if(donviSx.length() != 0) break;
        }
        this.donviSx = donviSx;
    }

    public void setLoai(String loai) {
        for(;;){
            System.out.print("Moi ban nhap loai Sach: ");
            loai = sc.nextLine();
            if(loai.length() != 0) break;
        }
        this.loai = loai;
    }
    
    @Override
    public void nhapSanpham(){
        setIdSanpham("");
        setName("");
        setTacgia("");
        setGia(0);
        setSoluong(0);
        setNgaySx("");
        setDonviSx("");
        setLoai("");
    }
    
    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s%-20.2f%-20d%-20s%-20s%-20s", idSanpham, name, gia, gia, soluong, ngaySx, donviSx, loai);
    }
    
    @Override
    public void xuatSanpham(){
        System.out.println(toString());
    }
    
    
    
}
