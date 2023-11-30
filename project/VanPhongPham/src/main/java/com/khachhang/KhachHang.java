package com.KhachHang;

import com.NguoiDung;
import java.io.*;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;

public class KhachHang extends NguoiDung {
    private String maNguoiDung;
    private String tenDangNhap;
    private String hoTen;
    private String soDienThoai;
    private String diaChi;

    // Default constructor
    public KhachHang() {
    }

    // Parameterized constructor
    public KhachHang(String maNguoiDung, String tenDangNhap, String hoTen, String soDienThoai, String diaChi) {
        this.maNguoiDung = maNguoiDung;
        this.tenDangNhap = tenDangNhap;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    // Copy constructor
    public KhachHang(KhachHang other) {
        this.maNguoiDung = other.maNguoiDung;
        this.tenDangNhap = other.tenDangNhap;
        this.hoTen = other.hoTen;
        this.soDienThoai = other.soDienThoai;
        this.diaChi = other.diaChi;
    }

    // Getters
    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    // Setters
    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    @Override
    void nhapThongTin(Scanner scanner) {
        System.out.print("Nhap ho ten: ");
        this.hoTen = scanner.nextLine();
        System.out.print("Nhap so dien thoai: ");
        this.soDienThoai = scanner.nextLine();
        System.out.print("Nhap dia chi: ");
        this.diaChi = scanner.nextLine();
    }
}


